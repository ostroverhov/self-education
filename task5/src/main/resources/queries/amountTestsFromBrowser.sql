SELECT COUNT(test.browser) AS 'BROWSER' FROM test WHERE test.browser = 'chrome'
UNION SELECT COUNT(test.browser) AS 'BROWSER' FROM test WHERE test.browser = 'firefox'