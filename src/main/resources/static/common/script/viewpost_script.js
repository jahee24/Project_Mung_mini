// 댓글 기능 관련
const viewPostCommentList = document.getElementById("viewPost-comment-list");
const viewPostCommentInput = document.getElementById("viewPost-comment-input");
const viewPostAddCommentBtn = document.getElementById("viewPost-add-comment");

// 댓글 추가 기능
viewPostAddCommentBtn.addEventListener("click", () => {
    const commentText = viewPostCommentInput.value.trim();
    if (commentText === "") {
        alert("댓글 내용을 입력해주세요.");
        return;
    }

    const commentItem = document.createElement("li");
    commentItem.className = "viewPost-comment-item";
    commentItem.innerHTML = `
        <span>${commentText}</span>
        <button class="viewPost-delete-comment">삭제</button>
    `;
    viewPostCommentList.appendChild(commentItem);
    viewPostCommentInput.value = "";

    // 댓글 삭제 이벤트 추가
    commentItem.querySelector(".viewPost-delete-comment").addEventListener("click", () => {
        if (confirm("이 댓글을 삭제하시겠습니까?")) {
            commentItem.remove();
        }
    });
});

// 게시물 관련 기능
const viewPostEditButton = document.getElementById("viewPost-edit");
const viewPostDeleteButton = document.getElementById("viewPost-delete");

// 게시물 수정 기능 (현재는 알림만 표시)
viewPostEditButton.addEventListener("click", () => {
    alert("게시물 수정 기능은 구현 중입니다.");
});

// 게시물 삭제 기능
viewPostDeleteButton.addEventListener("click", () => {
    if (confirm("이 게시물을 삭제하시겠습니까?")) {
        alert("게시물이 삭제되었습니다.");
        // 실제 삭제 로직은 구현 필요
    }
});
