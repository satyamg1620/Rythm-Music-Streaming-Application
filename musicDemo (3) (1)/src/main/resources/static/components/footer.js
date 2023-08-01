class MusicPlayer extends HTMLElement {
	constructor() {
		super();
	}

	connectedCallback() {
		this.innerHTML = `

      <div class="container" align="center">
		<div class="player">

			<div class="song-info">
				<div class="song-details">
					<span id="song-name"></span> <span id="song-artist"></span>
				</div>

				<!-- <i class="fa-solid fa-heart"></i> -->
				<p>
					<i id="likeHeart" class="far fa-heart"></i>
				</p>
			</div>
			<div class="song-duration">
				<div class="song-time">
					<div class="song-progress">
						<audio id='image' src="" class="audio responsive"></audio>
					</div>
				</div>
				<div class="time">
					<span>0:00</span> <span>0:00</span>
				</div>
			</div>
			
			<div id="music-player-controls">
				<div class="controls">
					<div id="song-image">
						<img src="images/TrackCoverPhotos/levitating.jpg" width="100px"
								height="80px" id=logo alt="Track Cover Image" style="margin-left: 10px;" />
					</div>
					<button class="player-btn" type="button">
						<i class="fa-solid fa-shuffle"></i>
					</button>
					<button class="player-btn prev-btn" type="button">
						<i class="fa-solid fa-backward"></i>
					</button>
					<button id="playPause" class="player-btn play-pause" type="button">
						<i class="fa-solid fa-play"></i>
					</button>
					<button class="player-btn next-btn" type="button">
						<i class="fa-solid fa-forward"></i>
					</button>
					<button class="player-btn" type="button">
						<i class="fa-solid fa-repeat"></i>
					</button>
					
					<div id="vol-control" style="float:right">
						<div class="vol-slider">
							<button  class="player-btn volume-btn" type="button">
								<i class="fa-solid fas fa-volume-up"></i>
							</button>
							<input type="range" id="slider" min="0" max="100" value="50" >
						</div>
					</div>
			</div>
			
			</div>
			
			<!-- <div class="player-footer">
          <i class="fa-sharp fa-solid fa-music"></i>
          <span>Listen to Rythm Music</span>
          <i class="fa-sharp fa-solid fa-list"></i>
        </div> -->
		</div>
	</div>
    `;
	}
}

customElements.define('music-player-component', MusicPlayer);
