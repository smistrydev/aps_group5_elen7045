'use strict';

/* jasmine specs for filters go here */

describe('filter', function() {

    beforeEach(module('routingRulesFilters'));


    describe('ruleWidth', function() {

        it('should calculate the width of the rule based on the start and end time',
            inject(function(ruleWidthFilter) {
                var input = {"startTime":"00:00","endTime":"06:59"};
                expect(ruleWidthFilter(input)).toBe(279);
            }));

        it('should calculate the width of the rule based on a zero start and end time',
            inject(function(ruleWidthFilter) {
                var input = {"startTime":"00:00","endTime":"00:00"};
                expect(ruleWidthFilter(input)).toBe(0);
            }));
    });

    describe('border', function() {

        it('should return the style rule as the boolean input is true',
            inject(function(borderFilter) {
                var input = true;
                expect(borderFilter(input, 'border-bottom-width: 1px')).toBe('border-bottom-width: 1px');
            }));

        it('should not return the style rule as the boolean input is false',
            inject(function(borderFilter) {
                var input = false;
                expect(borderFilter(input, 'border-bottom-width: 1px')).toBe('');
            }));
    });

    describe('currentTime', function() {

        it('should return the current time',
            inject(function(borderFilter) {

                expect(borderFilter(true)).toBe(undefined);
            }));
    });
});