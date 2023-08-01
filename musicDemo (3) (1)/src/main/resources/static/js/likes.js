/*const container = document.querySelector(".container");*/
/*let songName = document.getElementById("song-name");*/
// const songArtist = document.querySelector(".song-artist");
// const cover = document.querySelector(".cover");
// let playPauseBtn = document.querySelector(".play-pause");
// let audioPlayer = document.querySelector(".audio");
// const prevBtn = document.querySelector(".prev-btn");
// const nextBtn = document.querySelector(".next-btn");
// /*let aud = document.getElementById("image");*/
// const songTime = document.querySelector(".song-time");
// let songProgress = document.querySelector(".song-progress");
// const coverArtist = document.querySelector(".cover span:nth-child(1)");
// const coverName = document.querySelector(".cover span:nth-child(2)");

$(document).ready(function() {

	console.log("ON PAGE LOAD");
	alert("ON PAGE LOAD")

	const songArtist = document.querySelector(".song-artist");
	const cover = document.querySelector(".cover");
	let playPauseBtn = document.querySelector(".play-pause");
	let audioPlayer = document.querySelector(".audio");
	const prevBtn = document.querySelector(".prev-btn");
	const nextBtn = document.querySelector(".next-btn");
	/*let aud = document.getElementById("image");*/
	const songTime = document.querySelector(".song-time");
	let songProgress = document.querySelector(".song-progress");
	const coverArtist = document.querySelector(".cover span:nth-child(1)");
	const coverName = document.querySelector(".cover span:nth-child(2)");
	let volSlider = document.querySelector('.slider');
	let volumeBtn = document.querySelector(".volume-btn");
	/*let playlistId = document.getElementById('playlistId')
	console.log(playlistId);*/
	$.ajax({
		url: "http://localhost:8080/restTrack/likes"
	}).then(function(data) {
		// API Call For likedTracks
		$.ajax({
			// API2
			url: "http://localhost:8080/restTrack/likes"
		}).then(function(data2) {
			console.log(data2)
			let trackIds = [];
			for (var x = 0; x < data2.length; x++) {
				/*alert(data2[x].id+" "+ (typeof data2[x].id));*/
				trackIds.push(data2[x].id);
			}
			var table = document.getElementById('myTable')
			var source = ""
			for (var x = 0; x < data.length; x++) {
				source = "streaming/audio/" + data[x].trackPath
				var row = `<tr>
							<td class="highlight"><div></div></td>
							<td>${data[x].trackName}</td>
							<td>${data[x].trackPath}</td>
							<td><button  onClick="playSong('${source}', '${data[x].trackName}', '${data[x].id}', '${trackIds}')"><i class="fa-solid fa-play"></i></button></td>
						</tr>`
				table.innerHTML += row
			}
			console.log(source);
			console.log("AFTER SOURCE")
			$('#image').attr("src", source);
		})
	});

	playPauseBtn = document.querySelector(".play-pause");
	playPauseBtn.addEventListener("click", () => {
		console.log("INSIDE PLAYEPAUSE BUTTOn event listener");
		let container = document.querySelector(".container");
		if (container.classList.contains("pause")) {
			pauseTrack();
		}
		else {
			playTrack();
		}
	});
	audioPlayer = document.getElementById("image");
	audioPlayer.addEventListener("timeupdate", (e) => {
		const currentTime = e.target.currentTime;
		const duration = e.target.duration;
		let currentTimeWidth = (currentTime / duration) * 100;
		songProgress.style.width = `${currentTimeWidth}%`;

		let songCurrentTime = document.querySelector(".time span:nth-child(1)");
		let songDuration = document.querySelector(".time span:nth-child(2)");

		audioPlayer.addEventListener("loadeddata", () => {
			let audioDuration = audioPlayer.duration;
			let totalMinutes = Math.floor(audioDuration / 60);
			let totalSeconds = Math.floor(audioDuration % 60);

			if (totalSeconds < 10) {
				totalSeconds = `0${totalSeconds}`;
			}

			songDuration.textContent = `${totalMinutes}:${totalSeconds}`;
		});

		let currentMinutes = Math.floor(currentTime / 60);
		let currentSeconds = Math.floor(currentTime % 60);

		let durationMinutes = Math.floor(duration / 60);
		let durationSeconds = Math.floor(duration % 60)

		if (currentSeconds < 10) {
			currentSeconds = `0${currentSeconds}`;
		}

		songCurrentTime.textContent = `${currentMinutes}:${currentSeconds}`;
		songDuration.textContent = `${durationMinutes}:${durationSeconds}`;
	});

	songTime.addEventListener("click", (e) => {
		let progressWidth = songTime.clientWidth;
		let clickedOffsetX = e.offsetX;
		let songDuration = audioPlayer.duration;
		audioPlayer.currentTime = (clickedOffsetX / progressWidth) * songDuration;

		playSong();
	});
	volSlider = document.getElementById('slider');
	volSlider.addEventListener("input", function() {
		console.log("Inside Volume slider")
		audioPlayer.volume = this.value / 100;
	}, false);

	volumeBtn = document.querySelector(".volume-btn");
	volumeBtn.addEventListener("click", () => {
		if (volumeBtn.firstElementChild.className === "fa-solid fas fa-volume-up") {
			volumeBtn.firstElementChild.className = "fa-solid fas fa-volume-mute";
			audioPlayer.volume = 0;
		}
		else {
			volumeBtn.firstElementChild.className = "fa-solid fas fa-volume-up";
			audioPlayer.volume = volSlider.value / 100;
		}

	});

});

function playSong(path, trackName, trackId = null, trackIds = null) {
	if (!(trackId === null && trackIds == null)) {
		let heart = document.getElementById("likeHeart");
		if (trackIds.includes(trackId)) {
			heart.classList = "fas fa-heart";
		}
		else {
			heart.classList = "far fa-heart";
		}
	}

	let aud = document.getElementById("image");
	audioPlayer = aud;
	let songName = document.getElementById("song-name");
	let container = document.querySelector(".container");
	playPauseBtn = document.querySelector(".play-pause");

	$('#image').attr("src", path);
	songName.textContent = trackName;
	container.classList.add("pause");
	playPauseBtn.firstElementChild.className = "fa-solid fa-pause";
	aud.play();
}


let playTrack = () => {
	console.log("INSIDE  playTrack event listener");
	let container = document.querySelector(".container");
	let aud = document.getElementById("image");

	container.classList.add("pause");
	playPauseBtn.firstElementChild.className = "fa-solid fa-pause";
	aud.play();
};

let pauseTrack = () => {
	console.log("INSIDE pauseTrack event listener");
	let container = document.querySelector(".container");
	let aud = document.getElementById("image");

	container.classList.remove("pause");
	playPauseBtn.firstElementChild.className = "fa-solid fa-play";
	aud.pause();
};





