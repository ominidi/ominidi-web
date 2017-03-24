const gulp = require('gulp');
const sass = require('gulp-sass');
const sourcemaps = require('gulp-sourcemaps');
const ts = require('gulp-typescript');
const project = ts.createProject('tsconfig.json');

const staticFolder = 'src/main/resources/static/';

gulp.task('sass', function () {
    return gulp.src(`${staticFolder}/scss/**/*.scss`)
        .pipe(sourcemaps.init())
        .pipe(sass({
            outputStyle: 'expanded'
        }).on('error', sass.logError))
        .pipe(sourcemaps.write('.'))
        .pipe(gulp.dest(`${staticFolder}/dist/css`));
});

gulp.task('ts', () => {
    const result = project.src()
        .pipe(project());
    return result.js.pipe(gulp.dest(`${staticFolder}/dist/js`));
});

gulp.task('sass:watch', function () {
    gulp.watch(`${staticFolder}/scss/**/*.scss`, ['sass']);
});

gulp.task('ts:watch', ['ts'], () => {
    gulp.watch(`${staticFolder}/js/**/*.ts`, ['ts']);
});
