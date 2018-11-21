
INSERT INTO TAX_REBATE_THRESHOLD(ID ,YEAR, AGE_GROUP, REBATE, THRESHOLD) VALUES
    ('1','2017', 'primary', '13500.00', '75000.00'),
    ('2','2017', 'secondary', '7407.00', '116150.00'),
    ('3','2017', 'tertiary', '2466.00', '129850.00'),
    ('4','2018', 'primary', '13635.00', '75750.00'),
    ('5','2018', 'secondary', '7479.00', '117300.00'),
    ('6','2018', 'tertiary', '2493.00', '131150.00');


INSERT INTO TAX_TABLE (ID , TAX_YEAR, TAX_BRACKET1, TAX_BRACKET1TAX_RATE_PERC, TAX_BRACKET1TAX_RATE_AMOUNT, 
                        TAX_BRACKET2, TAX_BRACKET2TAX_RATE_PERC, TAX_BRACKET2TAX_RATE_AMOUNT,  
                        TAX_BRACKET3, TAX_BRACKET3TAX_RATE_PERC, TAX_BRACKET3TAX_RATE_AMOUNT, 
                        TAX_BRACKET4, TAX_BRACKET4TAX_RATE_PERC, TAX_BRACKET4TAX_RATE_AMOUNT,  
                        TAX_BRACKET5, TAX_BRACKET5TAX_RATE_PERC, TAX_BRACKET5TAX_RATE_AMOUNT, 
                        TAX_BRACKET6, TAX_BRACKET6TAX_RATE_PERC, TAX_BRACKET6TAX_RATE_AMOUNT, 
                        MEDICAL_AID_CREDIT_MAIN_AMOUNT, MEDICAL_AID_CREDIT_SECONDARY_AMOUNT)
            VALUES
                    ('1','2017', '188000.00', '0.18', '0.00',
                     '293600.00', '0.26', '33840.00',
                     '406400.00', '0.31', '61296.00',
                     '550100.00', '0.36', '96264.00',
                     '701300.00', '0.39', '147996.00',
                     '701301.00', '0.41', '206964.00',
                     '286.00', '192.00');
                     

INSERT INTO TAX_TABLE (ID , TAX_YEAR, TAX_BRACKET1, TAX_BRACKET1TAX_RATE_PERC, TAX_BRACKET1TAX_RATE_AMOUNT, 
                        TAX_BRACKET2, TAX_BRACKET2TAX_RATE_PERC, TAX_BRACKET2TAX_RATE_AMOUNT,  
                        TAX_BRACKET3, TAX_BRACKET3TAX_RATE_PERC, TAX_BRACKET3TAX_RATE_AMOUNT, 
                        TAX_BRACKET4, TAX_BRACKET4TAX_RATE_PERC, TAX_BRACKET4TAX_RATE_AMOUNT,  
                        TAX_BRACKET5, TAX_BRACKET5TAX_RATE_PERC, TAX_BRACKET5TAX_RATE_AMOUNT, 
                        TAX_BRACKET6, TAX_BRACKET6TAX_RATE_PERC, TAX_BRACKET6TAX_RATE_AMOUNT,  
                        TAX_BRACKET7, TAX_BRACKET7TAX_RATE_PERC, TAX_BRACKET7TAX_RATE_AMOUNT, 
                        MEDICAL_AID_CREDIT_MAIN_AMOUNT, MEDICAL_AID_CREDIT_SECONDARY_AMOUNT) 
            VALUES
                    ('2','2018', '189880.00', '0.18', '0.00',
                     '296540.00', '0.26', '34178.00',
                     '410460.00', '0.31', '61910.00',
                     '555600.00', '0.36', '97225.00',
                     '708310.00', '0.39', '149475.00',
                     '1500000.00', '0.41', '209032.00',
                     '1500001.00', '0.45', '533625.00',
                     '303.00', '204.00');