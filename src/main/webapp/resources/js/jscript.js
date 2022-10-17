//var jload = "/qldl/js/jtest.html #p1, #p3, .p7";
var jload = "https://www.w3schools.com/jquery/jquery_ajax_get_post.asp .w3-example";
var priceOrder = 0; var fetch; var URL; var moment;

$(document).ready(function () {
    $("#flip").click(function () {
        $("#panel").slideUp("slow");
        $("#flip").text(toPrice(12387.88, ' VNÐ'));
    });
});
$(document).ready(function () {
    $("button").click(function () {
        $("#div1").load("C:\Users\FPT SHOP\Documents\Juyn_Doc\demo_test.txt");
    });
});
$(document).ready(function () {
    $("button").click(function () {
        $("#box").load(jload);
    });
});
$("button").click(function () {
    $.get("https://gorest.co.in/public/v2/users", function (data, status) {
        $("#flip").text(data);
    });
});
function getFilePath() {
    $('input[type=file]').change(function () {
        let filePath = $('#file').val();
        return filePath;
    });
}

function toPrice(n, currency) {
    return String(n + '.').replace(/(\d)(?=(\d{3})+\.)/g, '$1,').replace('.', '') + currency; //.toFixed(2) | /(\d)(?=(\d{3})+\.)/g | +\.
}

function go() {
    let elements = document.getElementsByClassName('priceTour');
    for (let i = 0; i < elements.length; i++) {
        elements[i].text = toPrice(elements[i].text, ' VNÐ');
    }
}

$(document).ready(function () {
    for (j = 1; j <= $('.priceTour').length; j++) {
        $('#priceTour' + j).text(toPrice(parseInt($('#priceTour' + j).text()), ' VND'));
    }
});

var loadFile = function (event) {
    var output = document.getElementById('output');
    output.src = URL.createObjectURL(event.target.files[0]);
    output.onload = function () {
        URL.revokeObjectURL(output.src);                         // free memory
    };
};

document.addEventListener('DOMContentLoaded', function () {
    let dates = document.querySelectorAll(".my-date-j > i");
    for (let i = 0; i < dates.length; i++) {
        dates[i].innerText = moment(dates[i].innerText).fromNow() + " (" + dates[i].innerText + ")";
    }
    
    document.getElementById("priceTotal").innerHTML = toPrice(parseInt($('#priceTotal').text()), " VND");
//    for(let j = 0; j<$('.priceTour').length; j++) $('.priceTour:eq(' + j + ')').text(toPrice(parseInt($('.priceTour:eq(' + j + ')').text()), ' VND'));
    $('.priceTour').each(function () {
        $(this).text(toPrice(parseInt($(this).text()), ' VND'));
    });

//    fetch(`/qldl/api/order`).then(res => res.json()).then(data => {var totalNumOrder = document.getElementById("order-counter"); if (totalNumOrder !== null) totalNumOrder.innerText = data; });
}, false);

function addComment(tourId, userId) {
    fetch("/qldl/api/add-comment", {        // fetch("", {A:'', B: JSON.stringify({"a":'', "b": ''}), C:{"a":''} });
        method: 'post',
        body: JSON.stringify({              // JSON.stringify({"":"", "":""}),
            "content": document.getElementById("commentId").value,
            "tourId": tourId,
            "userId": userId
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        let area = document.getElementById("commentArea");
        area.innerHTML = `
        <div class="row" style="padding-bottom: 40px;">
            <div class="col-md-1">
                <img class="rounded-circle img-fluid" src="<c:url value="/images/img_no.png"/>" />
            </div>
            <div class="col-md-10 my-date-j">
                ${data.username} <br>
                ${data.content} <br>
                <i>${moment(data.postDate).fromNow()} (${data.postDate})</i>
            </div>
        </div>
        ` + area.innerHTML;
    });
}

function addToOrder(tourId) {
    fetch(`/qldl/api/order/${tourId}`).then(res => res.json()).then(data => {
        let totalNumOrder = document.getElementById("order-counter");
        if (totalNumOrder !== null)
            totalNumOrder.innerText = data;
    });
}

function updateOrder(objVal, tourId) {
    fetch("/qldl/api/order", {
        method: "put",
        body: JSON.stringify({              // Param equal(Name) AttriOfObj on Server
            "tourId": tourId,
            "tourName": "",
            "tourPrice": 0,
            "count": objVal.value
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(res => res.json()).then(data => {
        let counter = document.getElementById("order-counter");
        counter.innerText = data.countOrder;
        document.getElementById("priceTotal").innerHTML = toPrice(parseInt(data.priceOrder), " VND");
    });
}

function deleteOrder(tourId) {
    if (confirm("Do to want Continute To Delete") === true) {
        fetch(`/qldl/api/order/${tourId}`, {
            method: "delete"
        }).then(res => res.json()).then(data => {
            document.getElementById("order-counter").innerHTML = data.countOrder;
            this.priceOrder = data.priceOrder;
            document.getElementById("priceTotal").innerHTML = toPrice(parseInt(priceOrder), ' VNÐ');
            //location.reload();
            document.getElementById(`tour${tourId}`).style.display = "none";
        });
    }
}
    
function getIdUser(idUser) {
    fetch(`/qldl/api/pay/${idUser}`, {method:'post'}).then(res => res.json()).then(data => {
        location.reload();
        document.getElementById("priceTotal").innerHTML = data;
    });
}

var vnpay;
function payUrl(idUser) {
    //let amount = priceOrder; //$('#priceTotal').val();
    let bankcode = "";
    let language = "vn";
    fetch("/qldl/api/vnpay", {
        method: "post",
        body: JSON.stringify({      // Param equal(Name) AttriOfObj on Server
            "idUser": idUser,
            "bankcode": bankcode,
            "language": language    //$('#language').val()
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(res => res.json()).then(x => {
        if (x.code === '00') {
            if (window.vnpay) {
                vnpay.open({width: 768, height: 600, url: x.url});
            } else {
                location.href = x.url;
            }
            return false;
        } else {
            alert("Thanh Toan That Bai!");
        }
    });
}

function currentTime() {
//    let today = new Date();
//    let date = today.getFullYear() + '-' + (today.getMonth() + 1) + '-' + today.getDate();
//    document.getElementById("currentDate").value = date;
//
//    let today = new Date();
//    let time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
//    document.getElementById("currentTime").value = time;

    let today = new Date();
    let date = today.getFullYear() + '-' + (today.getMonth() + 1) + '-' + today.getDate();
    let time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
    let dateTime = date + ' ' + time;
    document.getElementById("date_time").innerHTML = dateTime;
}