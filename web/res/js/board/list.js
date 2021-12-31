function moveToDetail(iboard) {
    location.href='/board/detail?iboard=' + iboard;
}

function setEvent(tr) {
    tr.addEventListener('click', function (e) {
        console.log(tr.dataset.iboard);
        moveToDetail(tr.dataset.iboard);
    });
}
var trList = document.querySelectorAll('.record');
console.log(trList);

for (var i=0; i<trList.length; i++) {
    setEvent(trList[i]);
}

