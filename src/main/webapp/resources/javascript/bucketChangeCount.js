function add(bucketId, productId) {
    let str = "#count" + productId;
    let newCount = parseInt($(str).text()) + 1;
    fetch("http://localhost:8080/count", {
        method: 'POST',
        body: JSON.stringify({bucketId: bucketId, productId: productId, count: newCount})
    }).then(() => {
        $(str).text(newCount);
        $('#plus').blur();
        // document.location = document.location;
        // $('#count').load(location.href + " #count");
    });
}

function subtract(bucketId, productId) {
    let str = "#count" + productId;
    let newCount = parseInt($(str).text()) - 1;
    fetch("http://localhost:8080/count", {
        method: 'POST',
        body: JSON.stringify({bucketId: bucketId, productId: productId, count: newCount})
    }).then(() => {
        if (newCount === 0) {
            remove(bucketId, productId);
        } else {
            $(str).text(newCount);
            // document.location = document.location;
        }
        $('#minus').blur();
    });
}

function remove(bucketId, productId) {
    fetch("http://localhost:8080/bucket/remove", {
        method: 'POST',
        body: JSON.stringify({bucketId: bucketId, productId: productId})
    });
    document.location.reload();
}