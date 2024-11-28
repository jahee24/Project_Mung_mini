let currentNoticePage = 1; // 현재 페이지를 추적
// 공지사항 테스트 데이터
// 테스트 데이터
// 데이터 정의
const notices = [
    { title: " ", description: " ", image: "/mung/images/notice/image1.jpg" },
    { title: " ", description: " ", image: "/mung/images/notice/image2.jpg" },
    { title: " ", description: " ", image: "/mung/images/notice/image3.jpg" },
];

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
            }, 600); // 초기화 시간
        });
    });
}


// 초기화
document.addEventListener('DOMContentLoaded', () => {
    renderNotices();
});


// 페이지네이션 자동 호출
document.addEventListener('DOMContentLoaded', () => {
    renderTestNotices();
    renderNoticePagination();
});


// 페이지네이션 렌더링
function renderNoticePagination() {
    const noticesPerPage = 6;
    const totalPages = Math.ceil(notices.length / noticesPerPage);
    const paginationContainer = document.getElementById('notice-pagination');
    paginationContainer.innerHTML = ''; // 기존 버튼 초기화

    for (let i = 1; i <= totalPages; i++) {
        const button = document.createElement('button');
        button.textContent = i;
        button.className = i === currentNoticePage ? 'active' : '';
        button.onclick = () => renderNotices(i);
        paginationContainer.appendChild(button);
    }
}


// 공지사항 검색 기능
function searchNotices() {
    const searchTerm = document.getElementById('notice-search-input').value.toLowerCase();
    const filteredNotices = notices.filter(notice =>
        notice.title.toLowerCase().includes(searchTerm) ||
        notice.description.toLowerCase().includes(searchTerm) ||
        notice.author.toLowerCase().includes(searchTerm)
    );
    renderFilteredNotices(filteredNotices);
}

// 검색 결과 렌더링
function renderFilteredNotices(filteredNotices) {
    const container = document.getElementById('notice-container');
    container.innerHTML = '';
    filteredNotices.forEach(notice => {
        container.innerHTML += createCardTemplate(notice);
    });
}

// 공통 상세보기 창 열기 함수
function openDetailWindow(url, title) {
    const fullUrl = `${url}?title=${encodeURIComponent(title)}`;
    window.open(fullUrl, '_blank', 'width=800,height=600,scrollbars=yes');
}
