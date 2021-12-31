var btnContainerElem = document.querySelector('#btnContainer');
var btnDelElem = btnContainerElem.querySelector('#btnDel');

btnDelElem.addEventListener('click', function () {
    if(confirm('삭제하시겠습니까?')) {
        location.href = '/board/del?iboard=' + btnContainerElem.dataset.iboard;
    }
});