'use strict';

describe('RulesDisplay controllers', function() {

    //The $resource service augments the response object with methods for updating
    // and deleting the resource. If we were to use the standard toEqual matcher,
    // our tests would fail because the test values would not match the responses
    // exactly. To solve the problem, we use a newly-defined toEqualData Jasmine
    // matcher. When the toEqualData matcher compares two objects, it takes only
    // object properties into account and ignores methods.
    beforeEach(function(){
        this.addMatchers({
            toEqualData: function(expected) {
                return angular.equals(this.actual, expected);
            }
        });
    });

    // Load our app module definition before each test.
    beforeEach(module('routingRulesApp'));
    beforeEach(module('routingRulesServices'));

    describe('RulesDisplayCtrl', function(){

        var scope, ctrl, $httpBackend;

        var mockRuleSet = [{"ruleSetId":1,"ruleId":0,"currencyGroup":"2","currencyGroupDirection":0,"currencyGroupName":"Africa","currencyGroupNameDirection":0,"riskLocationId":"0","riskLocationIdDirection":1,"riskLocationName":"AFRICA","riskLocationNameDirection":1,"startTime":"00:00","startTimeDirection":0,"endTime":"06:59","endTimeDirection":0,"dayOfWeek":"1","dayOfWeekDirection":0,"dayOfWeekName":"Friday","dayOfWeekNameDirection":0,"instrument":"1","instumentDirection":0,"instrumentName":"Forward","instrumentNameDirection":0,"currenctGroupStatus":false,"riskLocationStatus":false,"startTimeStatus":false,"endTimeStatus":false,"dayOfWeekStatus":false,"instrumentStatus":false},{"ruleSetId":1,"ruleId":1,"currencyGroup":"1","currencyGroupDirection":0,"currencyGroupName":"G10","currencyGroupNameDirection":0,"riskLocationId":"0","riskLocationIdDirection":1,"riskLocationName":"AFRICA","riskLocationNameDirection":1,"startTime":"00:00","startTimeDirection":0,"endTime":"06:59","endTimeDirection":0,"dayOfWeek":"1","dayOfWeekDirection":0,"dayOfWeekName":"Friday","dayOfWeekNameDirection":0,"instrument":"1","instumentDirection":0,"instrumentName":"Forward","instrumentNameDirection":0,"currenctGroupStatus":false,"riskLocationStatus":false,"startTimeStatus":false,"endTimeStatus":false,"dayOfWeekStatus":false,"instrumentStatus":false}];

        // The injector ignores leading and trailing underscores here (i.e. _$httpBackend_).
        // This allows us to inject a service but then attach it to a variable
        // with the same name as the service.
        beforeEach(inject(function(_$httpBackend_, $rootScope, $controller) {

            $httpBackend = _$httpBackend_;
            var mockActiveRuleSet = {0: "5"};
            $httpBackend.when('GET', 'data/rulesets-activeRuleSetId.json').respond(mockActiveRuleSet);

            $httpBackend.when('GET', 'data/routing-ruleset-'+mockActiveRuleSet[0]+'.json').respond(mockRuleSet);

            scope = $rootScope.$new();
            ctrl = $controller('RulesDisplayCtrl', {$scope:scope});
        }));

        it('should return a valid formatted result set', function() {
            expect(scope.formattedResults).toEqualData(null);
            $httpBackend.flush();
            //var mockFormattedResults = "{ AfricaForward : [ { ruleSetId : 1, ruleId : 0, currencyGroup : '2', currencyGroupDirection : 0, currencyGroupName : 'Africa', currencyGroupNameDirection : 0, riskLocationId : '0', riskLocationIdDirection : 1, riskLocationName : 'AFRICA', riskLocationNameDirection : 1, startTime : '00:00', startTimeDirection : 0, endTime : '06:59', endTimeDirection : 0, dayOfWeek : '1', dayOfWeekDirection : 0, dayOfWeekName : 'Friday', dayOfWeekNameDirection : 0, instrument : '1', instumentDirection : 0, instrumentName : 'Forward', instrumentNameDirection : 0, currenctGroupStatus : false, riskLocationStatus : false, startTimeStatus : false, endTimeStatus : false, dayOfWeekStatus : false, instrumentStatus : false } ], G10Forward : [ { ruleSetId : 1, ruleId : 1, currencyGroup : '1', currencyGroupDirection : 0, currencyGroupName : 'G10', currencyGroupNameDirection : 0, riskLocationId : '0', riskLocationIdDirection : 1, riskLocationName : 'AFRICA', riskLocationNameDirection : 1, startTime : '00:00', startTimeDirection : 0, endTime : '06:59', endTimeDirection : 0, dayOfWeek : '1', dayOfWeekDirection : 0, dayOfWeekName : 'Friday', dayOfWeekNameDirection : 0, instrument : '1', instumentDirection : 0, instrumentName : 'Forward', instrumentNameDirection : 0, currenctGroupStatus : false, riskLocationStatus : false, startTimeStatus : false, endTimeStatus : false, dayOfWeekStatus : false, instrumentStatus : false } ] }";

            expect(scope.formattedResults[mockRuleSet[0].currencyGroupName+mockRuleSet[0].instrumentName]).toBeDefined();

            expect(scope.formattedResults[mockRuleSet[1].currencyGroupName+mockRuleSet[1].instrumentName]).toBeDefined();
            //expect(scope.formattedResults).toEqual(mockFormattedResults);
        });


    });
});