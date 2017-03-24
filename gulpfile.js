const gulp = require('gulp');
const sass = require('gulp-sass');
const sourcemaps = require('gulp-sourcemaps');
const ts = require('gulp-typescript');
const project = ts.createProject('tsconfig.json');

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

gulp.task('ts', () => {
    const result = project.src()
        .pipe(project());
    return result.js.pipe(gulp.dest(`${dest}/js`));
});

gulp.task('sass:watch', function () {
    gulp.watch(`${assets}/scss/**/*.scss`, ['sass']);
});

gulp.task('ts:watch', ['ts'], () => {
    gulp.watch(`${assets}/js/**/*.ts`, ['ts']);
});
