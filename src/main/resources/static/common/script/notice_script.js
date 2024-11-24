document.addEventListener('DOMContentLoaded', () => {
    // Reservation 링크 클릭 시 페이지 이동
    const reservationLink = document.querySelector('a[href="/reservation"]');
    if (reservationLink) {
        reservationLink.addEventListener('click', (event) => {
            event.preventDefault();
            window.location.href = '/mung/resv';
        });
    }

    // Support 서브메뉴 동작
    const supportMenu = document.querySelector('li a[href="#"]'); // Support 메뉴
    if (supportMenu) {
        const submenu = supportMenu.nextElementSibling; // 서브메뉴 박스

        // Support에 마우스 올리면 서브메뉴 표시
        supportMenu.addEventListener('mouseover', () => {
            if (submenu) submenu.style.display = 'block';
        });

        // 서브메뉴에도 마우스 올리면 숨기지 않음
        if (submenu) {
            submenu.addEventListener('mouseover', () => {
                submenu.style.display = 'block';
            });

            submenu.addEventListener('mouseout', (event) => {
                if (!submenu.contains(event.relatedTarget)) {
                    submenu.style.display = 'none';
                }
            });
        }

        // Support에서 마우스 떼면 서브메뉴 숨김
        supportMenu.addEventListener('mouseout', (event) => {
            if (!submenu.contains(event.relatedTarget)) {
                submenu.style.display = 'none';
            }
        });
    }

    // 서브메뉴 Notice 클릭 시 페이지 이동
    const noticeLink = document.getElementById('support-notice-link');
    if (noticeLink) {
        noticeLink.addEventListener('click', (event) => {
            event.preventDefault();
            window.location.href = '/mung/support/notice';
        });
    }

    // 서브메뉴 Q&A 클릭 시 페이지 이동
    const qnaLink = document.querySelector('a[href="/mung/support/qna"]');
    if (qnaLink) {
        qnaLink.addEventListener('click', (event) => {
            event.preventDefault();
            window.location.href = '/mung/support/qna';
        });
    }
});
