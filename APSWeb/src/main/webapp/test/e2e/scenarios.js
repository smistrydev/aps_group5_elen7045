describe('Risk Routing Rules App', function() {

    describe('View Routing Rules View', function() {

        beforeEach(function() {
            browser().navigateTo('../../risk-routing-rules.html');
        });


        it('should display all the currency group / row combinations', function() {
            expect(repeater('#routingRulesGrid .rulsetRow').count()).toBe(12);



            //input('query').enter('nexus');
            //expect(repeater('.phones li').count()).toBe(1);

            //input('query').enter('motorola');
            //expect(repeater('.phones li').count()).toBe(2);
        });


        it('should have a currency group and an instrument in each row', function() {

            expect(repeater('#routingRulesGrid .rulsetRow .ruleHead').count()).toBe(24);

            expect(repeater('#routingRulesGrid .rulsetRow .ruleHead').count()).toBe(24);
            /**
            element('#routingRulesGrid .rulsetRow').query(function (rulsetRow, done) {

                //console.log(rulsetRow);
                //expect(rulsetRow).toEqual(13)
                //expect(rulesetRowChildElementCount).toBe(3);

                var children = rulsetRow.children();
                for (var i = 0; i < children.length; i++) {

                    var rowItem = children[i];

                }

            });
             **/
        });

        it('should have a rule schedule in each row', function() {

            expect(repeater('#routingRulesGrid .rulsetRow .ruleSchedule').count()).toBe(12);

        });



    });
});