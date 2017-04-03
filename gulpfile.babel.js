import gulp from 'gulp';
import babelify from 'babelify';
import browserify from 'browserify';
import buffer from 'vinyl-buffer';
import cssmin from 'gulp-cssmin';
import rename from 'gulp-rename';
import sass from 'gulp-sass';
import sourcemaps from 'gulp-sourcemaps';
import source from 'vinyl-source-stream';
import uglify from 'gulp-uglify';

const assets = './assets';
const dest = 'src/main/resources/static/';

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
        entries: `${assets}/js/application/index.js`,
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

gulp.task('watch', ['sass:watch', 'js:watch']);
gulp.task('build', ['sass', 'cssmin', 'js', 'uglify']);