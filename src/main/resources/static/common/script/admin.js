document.getElementById('statusFilter').addEventListener('change', applyFilters);
document.getElementById('dateFilter').addEventListener('change', applyFilters);

async function applyFilters() {
    const status = document.getElementById('statusFilter').value;
    const dateRange = document.getElementById('dateFilter').value;

    try {
        const response = await fetch(`/reservations?status=${status}&dateRange=${dateRange}`);
        if (!response.ok) {
            throw new Error(`Failed to fetch reservations: ${response.statusText}`);
        }

        const parser = new DOMParser();
        const html = await response.text();
        document.querySelector('.square6_reservation_table tbody').innerHTML =
            new DOMParser().parseFromString(html, 'text/html').querySelector('.square6_reservation_table tbody').innerHTML;
    } catch (error) {
        console.error('Error:', error);
        alert('필터링된 데이터를 불러오는데 문제가 발생했습니다.');
    }
}
document.querySelectorAll('.btn-success, .btn-danger').forEach(button => {
    button.addEventListener('click', async function () {
        const id = this.closest('tr').querySelector('td').textContent; // 예약 ID 가져오기
        const newStatus = this.classList.contains('btn-success') ? '승인' : '취소';

        try {
            const response = await fetch(`/reservations/updateStatus`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ id, status: newStatus }),
            });

            if (response.ok) {
                alert('상태가 성공적으로 변경되었습니다.');
                location.reload(); // 상태가 변경되면 페이지 새로고침
            } else {
                throw new Error('상태 변경 실패');
            }
        } catch (error) {
            console.error('Error:', error);
            alert('상태 변경 중 문제가 발생했습니다.');
        }
    });
});
