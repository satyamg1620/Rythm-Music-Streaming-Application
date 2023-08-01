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
let currentTrackId = ''
let BASE_URL = 'http://localhost:8080';
let isCurTrackLiked = false;
$(document).ready(function() {

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
	let likeBtn = document.getElementById("likeHeart");
	let currentSrc = '';
	currentTrackId = '';
	BASE_URL = 'http://localhost:8080';
	isCurTrackLiked = false;
	let currentTrackName = '';
	let AllTrackIds = '';
	// API Call For all Tracks
	$.ajax({
		// API1
		url: BASE_URL + "/restTrack/tracks"
	}).then(function(data) {
		// API Call For likedTracks
		$.ajax({
			// API2
			url: BASE_URL + "/restTrack/likes"
		}).then(function(data2) {
			console.log(data2)
			let trackIds = [];
			for (var x = 0; x < data2.length; x++) {
				trackIds.push(data2[x].id);
			}

			var table = document.getElementById('myTable')
			var source = ""
			for (var x = 0; x < data.length; x++) {
				source = "streaming/audio/" + data[x].trackPath
				var row = `<tr>
							<td class="highlight"><div></div></td>
							<td>${data[x].trackName}</td>
							<!--<td>${data[x].trackPath}</td>-->
							<td><button  onClick="playSong('${source}', '${data[x].trackName}', '${data[x].id}', '${trackIds}')"><i class="fa-solid fa-play"></i></button></td>
						</tr>`
				table.innerHTML += row;

			}
			let element = document.getElementById("songs-list");
			let hidden = element.getAttribute("hidden");

			if (hidden) {
				element.removeAttribute("hidden");
				document.getElementById("my-music").setAttribute("hidden", "hidden");
			}
			console.log(source);
			console.log("AFTER SOURCE");
			$('#image').attr("src", source);
		})
	});
	
	let homeLink = document.getElementById("home-link");
	homeLink.addEventListener("click", (e) => {
		console.log('I clicked home button');
	});

	let myMusic = document.getElementById("home-link");
	myMusic.addEventListener("click", (e) => {
		console.log("Inside my music event listener")

		$.ajax({
			// API3 FOR LISTING MY MUSIC PLAYLIST
			url: BASE_URL + "/restUser/myMusic"
		}).then(function(data3) {
			console.log(data3);
			let playLists = [];
			let myMusic = document.getElementById('playlist-list');
			myMusic.innerHTML = "";
			let playlistCard = `
			<div class="col-sm-6">
			    <div class="card">
			      <img src="/siteImages/music_sqr_card.png" class="card-img-top"
			        alt="" />
			      <div class="card-body">
			        <h2 class="card-title">My Likes</h2>
			        <p hidden="hidden class="card-text">
			          This is a longer card with supporting text below as a natural lead-in to
			          additional content. This content is a little bit longer.
			        </p>
			      </div>
			    </div>
			  </div>
			`;
			myMusic.innerHTML += playlistCard;
			for (var x = 0; x < data3.length; x++) {
				playLists.push(data3[x]);
				playlistCard = `
			<div class="col-sm-6">
			    <div class="card">
			      <img src="/siteImages/music_sqr_card.png" class="card-img-top"
			        alt="" />
			      <div class="card-body">
			        <h2 class="card-title">${data3[x].playlistName}</h2>
			        <p hidden="hidden class="card-text">
			          This is a longer card with supporting text below as a natural lead-in to
			          additional content. This content is a little bit longer.
			        </p>
			      </div>
			    </div>
			  </div>
			`;
				myMusic.innerHTML += playlistCard;
			}
			let element = document.getElementById("my-music");
			let hidden = element.getAttribute("hidden");

			if (hidden) {
				element.removeAttribute("hidden");
				document.getElementById("songs-list").setAttribute("hidden", "hidden");
			}
		});

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
		console.log("Before home-link")
		document.getElementById("home-link").addEventListener("click", homeFunc);

		homeFunc = function() {
			//$('#songs-list').html(result).show(); 
			console.log("home func clicked")
			$('#content').hide();
		}

	});
	let heart = document.getElementById("likeHeart");
	heart.addEventListener("click", (e) => {
		//heart.classList = "fas fa-heart";
		console.log("Current trac id:", currentTrackId);
		if (!isCurTrackLiked) {
			e.preventDefault();
			console.log("Inside in likes")
			$.ajax({
				type: "GET",
				url: BASE_URL + "/likeRest" + "/likes/in/" + currentTrackId,
				//data: JSON.stringify(currentTrackId),
				//contentType: "application/json; charset=utf-8",
				success: function(result) {
					heart.classList = "fas fa-heart"
					isCurTrackLiked = true;
					if (result.status == "success") {

						console.log("SUCCESS");
					}
					else {
						console.log("FAILURE");
						console.log(url);
						//console.log(data);
						//console.log(contentType);
					}
				},
				error: function() {
					console.log("Error occured");
				}
			});
		}
		else {
			e.preventDefault();
			console.log("Inside del likes");
			$.ajax({
				type: "GET",
				url: BASE_URL + "/likeRest" + "/likes/del/" + currentTrackId,
				//data: currentTrackId,
				//contentType: "application/json; charset=utf-8",
				success: function() {
					isCurTrackLiked = false;
					console.log('Saved successfully!');
					heart.classList = "far fa-heart"
				},
				error: function() {
					console.log("Error occured");
				}
			});
		}
	});

});
// function playSong
function playSong(path, trackName, trackId = null, trackIds = null) {
	if (!(trackId === null && trackIds == null)) {
		let heart = document.getElementById("likeHeart");
		if (trackIds.includes(trackId)) {
			heart.classList = "fas fa-heart";
			isCurTrackLiked = true;
		}
		else {
			heart.classList = "far fa-heart";
			isCurTrackLiked = false;
		}
		currentSrc = path;
		currentTrackId = trackId;
		AllTrackIds = trackIds
	}
	/*document.getElementById("MyElement").classList = "myNewClass"*/
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





