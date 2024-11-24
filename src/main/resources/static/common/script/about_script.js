document.addEventListener('DOMContentLoaded', () => {
    initAboutPage();
});

function initAboutPage() {
    // 스크롤 애니메이션
    const parts = document.querySelectorAll('[class^="main-content-part"]');
    
    const observer = new IntersectionObserver((entries) => {
        entries.forEach((entry, index) => {
            if (entry.isIntersecting) {
                // 순차적 애니메이션을 위한 지연 시간 추가
                setTimeout(() => {
                    const container = entry.target.querySelector('[class$="-container"]');
                    container.classList.add('fade-in');
                }, index * 200); // 각 섹션마다 200ms 딜레이
            }
        });
    }, {
        threshold: 0.1,
        rootMargin: '50px'
    });

    parts.forEach(part => {
        observer.observe(part);
    });
}


