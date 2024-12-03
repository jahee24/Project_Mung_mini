let currentNoticePage = 1; // 현재 페이지를 추적

//리뷰 카드
const notices = [
    { title: " ", description: " ", image: "/mung/images/notice/image1.jpg" },
    { title: " ", description: " ", image: "/mung/images/notice/image2.jpg" },
    { title: " ", description: " ", image: "/mung/images/notice/image3.jpg" },
];

// 공지사항 테이블 렌더링 함수
function renderNoticeTable() {
    const tableBody = document.getElementById('notice-table-body');
    tableBody.innerHTML = ''; // 기존 내용 초기화

    // 테스트 데이터를 순회하며 테이블 행 추가
    testNotices.forEach((notice, index) => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${index + 1}</td> <!-- 순번 -->
            <td>${notice.title}</td> <!-- 제목 -->
            <td>${notice.author || '익명'}</td> <!-- 등록자명 -->
            <td>${notice.views || 0}</td> <!-- 조회수 -->
        `;
        tableBody.appendChild(row);
    });
}

// 초기화: 페이지 로드 시 공지사항 테이블 렌더링
document.addEventListener('DOMContentLoaded', () => {
    renderNoticeTable();
});

// 카드 렌더링 함수
function renderNotices() {
    const container = document.getElementById('notice-container');
    container.innerHTML = ''; // 기존 내용 초기화

    notices.forEach((notice) => {
        container.innerHTML += `
            <div class="notice-container-wrapper">
                <div class="notice-overlay"></div>
                <div class="notice-card" style="background-image: url('${notice.image}');">
                    <div class="notice-card-title">${notice.title}</div>
                    <div class="notice-card-description">${notice.description}</div>
                </div>
            </div>
        `;
    });

    applyHoverEffects(); // 카드 효과 적용
}

// 카드 효과 적용
function applyHoverEffects() {
    document.querySelectorAll('.notice-container-wrapper').forEach((container) => {
        const overlay = container.querySelector('.notice-overlay');
        let mouseEnterPos = { x: 0, y: 0 };

        // 마우스 진입 시 위치 저장
        container.addEventListener('mouseenter', (e) => {
            const rect = container.getBoundingClientRect();
            mouseEnterPos = { x: e.clientX - rect.left, y: e.clientY - rect.top };
        });

        // 마우스 이동 효과
        container.addEventListener('mousemove', (e) => {
            const rect = container.getBoundingClientRect();
            const x = e.clientX - rect.left;
            const y = e.clientY - rect.top;

            // 오버레이 효과
            overlay.style.background = `radial-gradient(circle at ${x}px ${y}px, 
            rgba(255, 255, 255, 0.5) 10%, 
            rgba(255, 219, 112, 0.3) 30%, 
            transparent 70%)`;
            overlay.style.opacity = '1'; // 마우스 움직임 시 빛 활성화

            // 카드 회전 효과
            const rotateX = (y / rect.height - 0.5) * 45;
            const rotateY = (x / rect.width - 0.5) * -45;
            container.style.transform = `rotateX(${rotateX}deg) rotateY(${rotateY}deg)`;
        });

        // 마우스 벗어날 때 효과
        container.addEventListener('mouseleave', (e) => {
            const rect = container.getBoundingClientRect();
            const mouseLeavePos = { x: e.clientX - rect.left, y: e.clientY - rect.top };

            // 진입-벗어남 방향 계산
            const deltaX = mouseLeavePos.x - mouseEnterPos.x;
            const deltaY = mouseLeavePos.y - mouseEnterPos.y;
            const rotateX = deltaY > 0 ? 15 : -15; // 상/하 방향 회전
            const rotateY = deltaX > 0 ? -15 : 15; // 좌/우 방향 회전

            // 부드러운 회전 후 초기화
            container.style.transform = `rotate3d(${rotateX / 15}, ${rotateY / 15}, 0, 20deg)`;
            overlay.style.filter = 'opacity(0)';
            setTimeout(() => {
                container.style.transform = 'rotateX(0) rotateY(0)';
            }, 1); // 초기화 시간
        });
    });
}

// 공지사항 검색 기능
function searchNotices() {
    const searchTerm = document.getElementById('notice-search-input').value.toLowerCase();
    const filteredNotices = testNotices.filter(notice =>
        notice.title.toLowerCase().includes(searchTerm) ||
        notice.description.toLowerCase().includes(searchTerm) ||
        notice.author.toLowerCase().includes(searchTerm)
    );
    renderFilteredNotices(filteredNotices); // 필터링된 데이터 렌더링
}

// 검색 결과 렌더링
function renderFilteredNotices(filteredNotices) {
    const tableBody = document.getElementById('notice-table-body');
    tableBody.innerHTML = ''; // 기존 내용 초기화

    filteredNotices.forEach((notice, index) => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${index + 1}</td> <!-- 순번 -->
            <td>${notice.title}</td> <!-- 제목 -->
            <td>${notice.author || '익명'}</td> <!-- 등록자명 -->
            <td>${notice.views || 0}</td> <!-- 조회수 -->
        `;
        tableBody.appendChild(row);
    });
}


/*페이지 개 효과*/
const dog = document.querySelector('.animated-dog');

function animateAlongCurve() {
    let t = 0; // 진행 비율 (0 ~ 1)
    const duration = 2000; // 이동 시간 (2초)
    const startX = Math.random() * 90 + 5; // 시작점 X
    const startY = Math.random() * 90 + 5; // 시작점 Y
    const endX = Math.random() * 90 + 5; // 종료점 X
    const endY = Math.random() * 90 + 5; // 종료점 Y
    const controlX = Math.random() * 90 + 5; // 곡선 제어점 X
    const controlY = Math.random() * 90 + 5; // 곡선 제어점 Y

    function animate() {
        t += 0.01; // 진행 비율 증가
        if (t > 1) t = 1; // 최대 값 제한

        // 베지어 곡선 계산
        const currentX = (1 - t) ** 2 * startX + 2 * (1 - t) * t * controlX + t ** 2 * endX;
        const currentY = (1 - t) ** 2 * startY + 2 * (1 - t) * t * controlY + t ** 2 * endY;

        dog.style.left = `${currentX}%`;
        dog.style.top = `${currentY}%`;

        if (t < 1) requestAnimationFrame(animate); // 이동이 완료되면 반복 종료
    }

    animate();
}

// 2초마다 새로운 곡선 경로로 이동
setInterval(animateAlongCurve, 2000);


// 공지사항 테이블 렌더링
function renderNoticeTable(page = 1) {
    const noticesPerPage = 6; // 한 페이지에 표시할 공지사항 수
    const startIndex = (page - 1) * noticesPerPage;
    const endIndex = startIndex + noticesPerPage;
    const tableBody = document.getElementById('notice-table-body');
    tableBody.innerHTML = ''; // 기존 내용 초기화

    // 현재 페이지 데이터만 순회하여 테이블에 추가
    testNotices.slice(startIndex, endIndex).forEach((notice, index) => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${startIndex + index + 1}</td> <!-- 순번 -->
            <td onclick="openDetailWindow('/mung/viewPost?id=${notice.id}', '${notice.title}')">
                ${notice.title}
            </td> <!-- 제목 -->
            <td>${notice.author || '익명'}</td> <!-- 등록자명 -->
            <td>${notice.views || 0}</td> <!-- 조회수 -->
        `;
        tableBody.appendChild(row);
    });
}

// 페이지네이션 버튼 생성
function renderNoticePagination() {
    const noticesPerPage = 6; // 한 페이지에 표시할 공지사항 수
    const totalPages = Math.ceil(testNotices.length / noticesPerPage);
    const paginationContainer = document.getElementById('testNotice-pagination');
    paginationContainer.innerHTML = ''; // 기존 버튼 초기화

    for (let i = 1; i <= totalPages; i++) {
        const button = document.createElement('button');
        button.textContent = i;
        button.className = i === currentNoticePage ? 'active' : '';
        button.onclick = () => {
            currentNoticePage = i;
            renderNoticeTable(i);
            renderNoticePagination();
        };
        paginationContainer.appendChild(button);
    }
}

// 게시글 상세보기 창 열기 함수
function openDetailWindow(postId) {
    const url = `/mung/support/notice/viewPost/${postId}`;  // 해당 게시글의 상세 URL
    window.open(url, '_blank', 'width=800,height=600,scrollbars=yes');  // 새 창으로 열기
}
// 새 글 작성 창 열기 함수
function openNewPost() {
    const url = `/mung/support/notice/newPost`;  // 새 글 작성 페이지 URL
    window.open(url, '_blank', 'width=800,height=600,scrollbars=yes');  // 새 창으로 열기
}





//메인 페이지 통합 랜더링
document.addEventListener('DOMContentLoaded', () => {
    renderNotices(); // 리뷰 카드 렌더링
    renderNoticeTable(); // 공지사항 테이블 렌더링
    renderNoticePagination(); // 페이지네이션 렌더링
});