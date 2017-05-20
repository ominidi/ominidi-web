import gulp from 'gulp';
import babelify from 'babelify';
import browserify from 'browserify';
import buffer from 'vinyl-buffer';
import cssmin from 'gulp-cssmin';
import mocha from 'gulp-mocha';
import rename from 'gulp-rename';
import sass from 'gulp-sass';
import sequence from 'run-sequence';
import sourcemaps from 'gulp-sourcemaps';
import source from 'vinyl-source-stream';
import swPrecache from 'sw-precache';
import uglify from 'gulp-uglify';

const assets = './assets';
const dest = 'src/main/resources/static';

gulp.task('sass', function () {
    return gulp.src(`${assets}/scss/**/*.scss`)
        .pipe(sourcemaps.init())
        .pipe(sass({
            outputStyle: 'expanded'
        }).on('error', sass.logError))
        .pipe(sourcemaps.write('.'))
        .pipe(gulp.dest(`${dest}/css`));
});

gulp.task('sass:watch', function () {
    gulp.watch(`${assets}/scss/**/*.scss`, ['sass']);
});

gulp.task('js', () => {
    return browserify({
        entries: `${assets}/js/application/src/index.js`,
        extensions: ['.js', '.jsx'],
        debug: true
    })
        .transform('babelify', {presets: ['es2015', 'react']})
        .bundle()
        .pipe(source('index.js'))
        .pipe(buffer())
        .pipe(sourcemaps.init({
            loadMaps: true
        }))
        .pipe(rename('bundle.js'))
        .pipe(sourcemaps.write('.'))
        .pipe(gulp.dest(`${dest}/js`));
});

gulp.task('js:watch', () => {
    gulp.watch(`${assets}/js/**/*`, ['js']);
});

gulp.task('cssmin', () => {
    return gulp.src(`${dest}/css/style.css`)
        .pipe(cssmin())
        .pipe(rename({suffix: '.min'}))
        .pipe(gulp.dest(`${dest}/css`));
});

gulp.task('uglify', () => {
    return gulp.src(`${dest}/js/bundle.js`)
        .pipe(rename({suffix: '.min'}))
        .pipe(uglify())
        .pipe(gulp.dest(`${dest}/js`));
});

gulp.task('mocha', () => {
    return gulp.src(`${assets}/js/application/test/**/*`)
        .pipe(mocha({
            compilers: 'js:babel-core/register'
        }));
});

gulp.task('service-worker', (cb) => {
    swPrecache.write(`${dest}/sw.js`, {
        runtimeCaching: [
            {
                urlPattern: '/*',
                handler: 'fastest'
            },
            {
                urlPattern: /\/api\/v1\//,
                handler: 'networkFirst'
            },
            {
                urlPattern: /^https:\/\/scontent\.xx\.fbcdn\.net\/.*/,
                handler: 'networkFirst'

            }
        ],
        staticFileGlobs: [
            `${dest}/css/**/*.css`,
            `${dest}/js/**/*.js`,
            `${dest}/img/**/*.{png,jpg,gif,svg}`,
            `${dest}/fonts/*.{svg,eot,ttf,woff}`
        ],
        stripPrefix: `${dest}`,
        verbose: true
    }, cb);
});

gulp.task('copy', () => {
    return gulp.src(`${assets}/js/sw-registration.js`)
        .pipe(gulp.dest(`${dest}/js/`))
});

gulp.task('watch', ['sass:watch', 'js:watch']);
gulp.task('test', ['mocha']);
gulp.task('build', () => {
    return sequence(
        ['sass', 'js'],
        ['cssmin', 'uglify'],
        ['service-worker', 'copy']
    )
});