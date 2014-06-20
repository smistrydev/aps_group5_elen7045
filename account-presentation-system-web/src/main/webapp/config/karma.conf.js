module.exports = function(config){
  config.set({
    basePath : '../',

    files : [
      'lib/angular/angular.js',
      'lib/angular/angular-*.js',
      'lib/bootstrap/js/ui-bootstrap-tpls-0.10.0.min.js',
      'js/**/*.js',
      'test/unit/**/*.js'
    ],

    exclude : [
      'lib/angular/angular-loader.js',
      'lib/angular/*.min.js',
      'lib/angular/angular-scenario.js'
    ],

    autoWatch : true,

    frameworks: ['jasmine'],

    browsers : ['Chrome'],

    plugins : [
            'karma-junit-reporter',
            'karma-chrome-launcher',
            'karma-firefox-launcher',
            'karma-script-launcher',
            'karma-jasmine'
            ],

    junitReporter : {
      outputFile: 'test_out/unit.xml',
      suite: 'unit'
    }

    //preprocessors: {
    //  'templates/**/*.html': ['ng-html2js']
    //},

    //ngHtml2JsPreprocessor: {
      // setting this option will create only a single module that contains templates
      // from all the files, so you can load them all with module('foo')
    //  moduleName: 'templates'
    //},

    //files: [
      // ...
    //  'templates/**/*.html'
    //]

  });
};
