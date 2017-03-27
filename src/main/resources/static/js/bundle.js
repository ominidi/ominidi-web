System.register("module", [], function (exports_1, context_1) {
    "use strict";
    var __moduleName = context_1 && context_1.id;
    var add;
    return {
        setters: [],
        execute: function () {
            add = (a, b) => a + b;
            exports_1("default", add);
        }
    };
});
System.register("index", ["module"], function (exports_2, context_2) {
    "use strict";
    var __moduleName = context_2 && context_2.id;
    var module_1, a, b;
    return {
        setters: [
            function (module_1_1) {
                module_1 = module_1_1;
            }
        ],
        execute: function () {
            a = 2;
            b = 1;
            console.log(module_1.default(1, 2));
        }
    };
});
