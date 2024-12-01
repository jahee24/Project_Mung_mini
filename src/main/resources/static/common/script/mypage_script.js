$(document).ready(function () {
    const today = new Date();
    document.querySelectorAll("button[data-resv-date]").forEach(button => {
        const resvDate = new Date(button.getAttribute("data-resv-date"));
        if (resvDate <= today) {
            button.style.display = "none";
        } else {
            button.addEventListener("click", () => {
                if (confirm("예약을 취소하시겠습니까?")) {
                    const resvNum = button.getAttribute("data-resv-num");
                    // 예약 취소 API 호출
                    fetch(`/reservation/cancel/${resvNum}`, {
                        method: "POST",
                    })
                        .then(response => {
                            if (response.ok) {
                                alert("예약이 취소되었습니다.");
                                location.reload();
                            } else {
                                alert("예약 취소에 실패했습니다.");
                            }
                        })
                        .catch(err => alert("오류가 발생했습니다: " + err));
                }
            });
        }
    });

    function confirmCancel(resvNum) {
        if (confirm("예약을 취소하시겠습니까?")) {
            // 예약 취소 API 호출
            fetch(`/reservation/cancel/${resvNum}`, {
                method: "POST",
            })
                .then(response => {
                    if (response.ok) {
                        alert("예약이 취소되었습니다.");
                        location.reload(); // 페이지 새로고침
                    } else {
                        alert("예약 취소에 실패했습니다. 다시 시도해주세요.");
                    }
                })
                .catch(error => {
                    console.error("Error cancelling reservation:", error);
                    alert("오류가 발생했습니다. 다시 시도해주세요.");
                });
        }
    }
    // 강아지 프로필 사진 등록
    $('#dogImage').submit(function(event) {
        event.preventDefault(); // 폼 기본 제출을 방지
        var formData = new FormData(this);

        $.ajax({
            url: '/mypage/uploadImage',  // 백엔드의 URL
            type: 'POST',
            data: formData,
            contentType: false,
            processData: false,
            success: function(response) {
                $('#message').html('<div class="alert alert-success">사진이 성공적으로 업로드되었습니다!</div>');
            },
            error: function() {
                $('#message').html('<div class="alert alert-danger">업로드 중 오류가 발생했습니다.</div>');
            }
        });
    });

    // weight dropdown
    const weightSelect = document.getElementById("weight");
    // 1.0kg부터 40.0kg까지 범위 생성
    for (let i = 1.0; i <= 40.0; i += 0.1) {
        const option = document.createElement("option");
        const value = i.toFixed(1); // 소수점 한 자리로 고정
        option.value = parseFloat(value);
        console.log(typeof option.value)
        option.textContent = `${value}kg`;
        weightSelect.appendChild(option);
    }

    // breed dropdown
    const breedSelect = document.getElementById("breed");
    // 견종 목록
    const breeds = [
        "시츄",
        "푸들",
        "불독",
        "골든 리트리버",
        "비글",
        "치와와",
        "닥스훈트",
        "셰퍼드",
        "도베르만",
        "허스키",
        "말티즈",
        "믹스견 (Mixed)" // 마지막에 믹스견 추가
    ];

    // 견종 옵션 생성
    breeds.forEach(breed => {
        const option = document.createElement("option");
        option.value = breed; // 값
        option.textContent = breed; // 표시 텍스트
        breedSelect.appendChild(option);
    });
})

function loadDogInfo(dogId) {
    console.log("helloo");
    console.log(dogId);

    // dogId가 올바르게 전달되었는지 확인
    if (!dogId) {
        console.error("dogId is null or undefined");
        return; // dogId가 없으면 더 이상 진행하지 않음
    }

    // AJAX 요청을 보냄
    $.ajax({
        url: `/mung/mypage/dogProfile/${dogId}`,
        method: "get",
        dataType: 'json',
        success: function (dog) {
            console.log(dog); // dog 정보 확인

            var modalElement = document.getElementById('exampleModal');
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
        /* document.getElementById('dog-name').innerHTML = dog.name;
       document.getElementById('dog-age').innerHTML = dog.age;
       document.getElementById('dog-gender').innerHTML = dog.gender;
       document.getElementById('dog-breed').innerHTML = dog.breed;
       document.getElementById('dog-birthDate').innerHTML = dog.birthDate;
       document.getElementById('dog-weight').innerHTML = dog.weight + 'kg';
       document.querySelector('.square5_profile_img').src = dog.imageUrl || '/default-image.png'; // 기본 이미지 처리
   },*/
        error: function (xhr, status, error) {
            console.error('Error loading dog profile:', error);
            alert('Failed to load dog profile. Please try again.');
        }
    });
}

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
*/
// 모달 초기화
document.addEventListener('DOMContentLoaded', function() {
    // 등록 모달이 닫힐 때 폼 초기화
    const registerModal = document.getElementById('dogRegisterModal');
    registerModal?.addEventListener('hidden.bs.modal', function() {
        document.querySelector('.square5_dog_register_form').reset();
        document.getElementById('preview').src = '../images/dog-placeholder.png';
    });
});