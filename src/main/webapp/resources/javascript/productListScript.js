function buyNow(id, count) {
    fetch("http://localhost:8080/bucket/add", {
        method: 'POST',
        body: JSON.stringify({id: id})
    }).then(() => {
        let itemId = '#basket' + id;
        $(itemId).attr('src', '/resources/image/in_basket.png');
        let productsCount = count + 1;
        let str = "Bucket (" + productsCount + ")";
        $('#bucket-count').text(str);
        // sessionStorage.setItem('productsInBucket', count);
        console.log("success");


        // sessionStorage.setItem('productsInBucket', sessionStorage.getItem('productsInBucket') + 1);
    });

    // let temp = count.text();
    // // count.textContent = '[temp + 1]';
    // count.change = temp + 1

    // let tmp = parseInt($('#count').text()) + 1;
    // $('#count').text(tmp)
}