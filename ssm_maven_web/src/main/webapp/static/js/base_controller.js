// 为应用程序（app）定义一个基础控制器：baseController
app.controller('baseController', function ($rootScope) {

    // 刷新ids数组中已选中的id元素
    $rootScope.refreshIds = function () {
        $rootScope.ids = [];
        var idsAll = document.getElementsByName("ids");
        for (var i=0; i<idsAll.length; i++) {
            if (idsAll[i].checked) {
                $rootScope.ids.push(idsAll[i].value);
                console.log($rootScope.ids);
            }
        }
    };

    // 单选
    $rootScope.selectOne = function () {
        $rootScope.refreshIds();
    };

    // 全选/全不选
    $rootScope.selectAll = function () {
        var idsAll = document.getElementsByName("ids");
        for (var i=0; i<idsAll.length; i++) {
            if (idsAll[i].checked) {
                for (var x=0; x<idsAll.length; x++) {
                    idsAll[x].checked = false;
                }
                $rootScope.refreshIds();
                return;
            }
        }
        for (var y=0; y<idsAll.length; y++) {
            idsAll[y].checked = true;
        }
        $rootScope.refreshIds();
    };

    // 反选
    $rootScope.selectRes = function () {
        var idsAll = document.getElementsByName("ids");
        for (var i=0; i<idsAll.length; i++) {
            idsAll[i].checked = idsAll[i].checked !== true;
        }
        $rootScope.refreshIds();
    };

});