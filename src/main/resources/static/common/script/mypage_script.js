document.addEventListener('DOMContentLoaded', function() {
    // 모달을 로드하기 전에 DOM이 준비되었는지 확인합니다.
    console.log("DOM fully loaded");

    function loadDogProfile(dogId) {
        console.log("helloo");
        console.log(dogId);

        // dogId가 올바르게 전달되었는지 확인
        if (!dogId) {
            console.error("dogId is null or undefined");
            return; // dogId가 없으면 더 이상 진행하지 않음
        }

        // AJAX 요청을 보냄
        $.ajax({
            url: "/mung/mypage/dogProfile/" + dogId,
            method: 'GET',
            dataType: 'json',
            success: function(dog) {
                console.log(dog); // dog 정보 확인

                var modalElement = document.getElementById('dogProfileModal');
                if (!modalElement) {
                    console.error("Modal element not found!");
                    return;
                }

                var modal = new bootstrap.Modal(modalElement);
                modal.show(); // 모달 열기

                // 프로필 데이터 업데이트
                document.getElementById('dog-name').textContent = dog.name;
                document.getElementById('dog-age').textContent = dog.age;
                document.getElementById('dog-gender').textContent = dog.gender;
                document.getElementById('dog-breed').textContent = dog.breed;
                document.getElementById('dog-birthDate').textContent = dog.birthDate;
                document.getElementById('dog-weight').textContent = dog.weight + 'kg';
                document.querySelector('.square5_profile_img').src = dog.imageUrl || '/default-image.png'; // 기본 이미지 처리
            },
            error: function(xhr, status, error) {
                console.error('Error loading dog profile:', error);
                alert('Failed to load dog profile. Please try again.');
            }
        });
    }

});

/*

function loadDogProfile222(dogId) {
    // AJAX를 사용하여 서버에서 반려견 정보를 가져옴
    fetch(`/mung/mypage/dogProfile`)/!*!/api/dogs/${dogId}*!/
        .then(response => response.json())
        .then(dog => {
            // 프로필 모달의 내용을 업데이트
            document.getElementById('dog-name').textContent = data.name;
            document.getElementById('dog-age').textContent = data.age;
            document.getElementById('dog-gender').textContent = dag.gender;
            document.getElementById('dog-breed').textContent = dog.breed;
            document.getElementById('dog-birthDate').textContent = data.birthDate;
            document.getElementById('dog-weight').textContent =  dog.weight/!* + 'kg'*!/;
            document.querySelector('.square5_profile_img').src = dog.imageUrl;


                        document.querySelector('#ModalDogProfile .square5_profile_img').src ='/mypage/'+dog.imageUrl;
                        document.querySelector('#ModalDogProfile [data-dog-name]').textContent = dog.name;
                        document.querySelector('#ModalDogProfile [data-dog-age]').textContent = dog.age + '살';
                        document.querySelector('#ModalDogProfile [data-dog-gender]').textContent = dog.gender;
                            /!*dog.dogGender === 'male' ? '남아' : '여아';*!/
                        document.querySelector('#ModalDogProfile [data-dog-breed]').textContent = dog.breed;
                        document.querySelector('#ModalDogProfile [data-meet-date]').textContent =
                            formatDate(dog.meetDate);
                        document.querySelector('#ModalDogProfile [data-dog-weight]').textContent =
                            dog.weight + 'kg';

        });
}

*/

/*
// 이미지 미리보기
document.getElementById('dogImage')?.addEventListener('change', function(e) {
    const preview = document.getElementById('preview');
    const file = e.target.files[0];
    const reader = new FileReader();

    reader.onloadend = function() {
        preview.src = reader.result;
    }

    if (file) {
        reader.readAsDataURL(file);
    }
});

// 날짜 포맷 함수
function formatDate(dateString) {
    const date = new Date(dateString);
    return `${date.getFullYear()}년 ${date.getMonth() + 1}월 ${date.getDate()}일`;
}

// 모달 초기화
document.addEventListener('DOMContentLoaded', function() {
    // 등록 모달이 닫힐 때 폼 초기화
    const registerModal = document.getElementById('dogRegisterModal');
    registerModal?.addEventListener('hidden.bs.modal', function() {
        document.querySelector('.square5_dog_register_form').reset();
        document.getElementById('preview').src = '../images/dog-placeholder.png';
    });
});*/