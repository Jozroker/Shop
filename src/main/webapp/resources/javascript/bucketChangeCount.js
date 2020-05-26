function add(bucketId, productId, count) {
    let newCount = count + 1;
    fetch("http://localhost:8080/count", {
        method: 'POST',
        body: JSON.stringify({bucketId: bucketId, productId: productId, count: newCount})
    }).then(() => {
        // $('#count').text(newCount);
        document.location = document.location;
        // $('#count').load(location.href + " #count");
    });
}

function subtract(bucketId, productId, count) {
    let newCount = count - 1;
    fetch("http://localhost:8080/count", {
        method: 'POST',
        body: JSON.stringify({bucketId: bucketId, productId: productId, count: newCount})
    }).then(() => {
        if (newCount === 0) {
            fetch("http://localhost:8080/bucket/remove", {
                method: 'POST',
                body: JSON.stringify({bucketId: bucketId, productId: productId})
            });
            document.location.reload();
        } else {
            // $('#count').text(newCount);
            document.location = document.location;
        }
    });
}