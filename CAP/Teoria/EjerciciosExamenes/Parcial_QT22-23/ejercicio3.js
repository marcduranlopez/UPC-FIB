function scanl_cps_tranpoline(f,x0,arr,ret) {
    function scanl_cps(f,x0,arr,ret) {
        if (arr.length === 0) {
        return ret([x0])
        } else {
            let car = arr[0];
            let cdr = arr.slice(1);
            
            return function() {
             return scanl_cps(f,f(x0,car),cdr, function (result) {
                return ret([x0].concat(result));
        })
        }
    }
}

    return scanl_cps_tranpoline(scanl_cps(f,x0,arr,ret));
}
