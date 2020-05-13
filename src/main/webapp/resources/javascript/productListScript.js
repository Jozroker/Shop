function buyNow(id) {
    fetch("http://localhost:8080/bucket/add", {
        method: 'POST',
        body: JSON.stringify({id: id})
    }).then(() => {
        let itemId = '#basket' + id;
        $(itemId).attr('src', '/resources/image/in_basket.png');
        console.log("success");


        // sessionStorage.setItem('productsInBucket', sessionStorage.getItem('productsInBucket') + 1);
    });

    // let temp = count.text();
    // // count.textContent = '[temp + 1]';
    // count.change = temp + 1

    // let tmp = parseInt($('#count').text()) + 1;
    // $('#count').text(tmp)
}