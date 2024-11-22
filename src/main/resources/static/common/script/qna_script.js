// 팝업 열기 및 닫기
const openPopup = document.getElementById('openPopup');
const closePopup = document.getElementById('overlay');
const popup = document.getElementById('popup');
const overlay = document.getElementById('overlay');

openPopup.addEventListener('click', () => {
    popup.style.display = 'block';
    overlay.style.display = 'block';
});

overlay.addEventListener('click', () => {
    popup.style.display = 'none';
    overlay.style.display = 'none';
});

// 질문 등록 기능
document.getElementById('submitBtn').addEventListener('click', function () {
    const title = document.getElementById('title').value.trim();
    const content = document.getElementById('content').value.trim();

    if (!title || !content) {
        alert('제목과 내용을 모두 입력하세요.');
        return;
    }

    // 질문 목록에 새로운 항목 추가
    const questionList = document.getElementById('questionList');
    const newItem = document.createElement('li');
    newItem.innerHTML = `
    <div class="title">${title}</div>
    <div class="content">${content}</div>
    <div class="actions">
      <button class="edit">수정</button>
      <button class="delete">삭제</button>
      <button class="comment">댓글달기</button>
    </div>
  `;
    questionList.prepend(newItem);

    // 수정 기능
    newItem.querySelector('.edit').addEventListener('click', function () {
        const newTitle = prompt('새로운 제목:', title);
        const newContent = prompt('새로운 내용:', content);
        if (newTitle) newItem.querySelector('.title').textContent = newTitle;
        if (newContent) newItem.querySelector('.content').textContent = newContent;
    });

    // 삭제 기능
    newItem.querySelector('.delete').addEventListener('click', function () {
        if (confirm('정말 삭제하시겠습니까?')) {
            newItem.remove();
        }
    });

    // 댓글 달기 기능
    newItem.querySelector('.comment').addEventListener('click', function () {
        const comment = prompt('댓글을 입력하세요:');
        if (comment) {
            const commentDiv = document.createElement('div');
            commentDiv.textContent = `댓글: ${comment}`;
            commentDiv.style.marginTop = '10px';
            newItem.appendChild(commentDiv);
        }
    });

    // 제목 클릭 시 내용 펼쳐보기
    newItem.querySelector('.title').addEventListener('click', function () {
        const content = newItem.querySelector('.content');
        content.style.display = content.style.display === 'none' || content.style.display === '' ? 'block' : 'none';
    });

    // 입력 필드 초기화 및 팝업 닫기
    document.getElementById('title').value = '';
    document.getElementById('content').value = '';
    popup.style.display = 'none';
    overlay.style.display = 'none';
});
