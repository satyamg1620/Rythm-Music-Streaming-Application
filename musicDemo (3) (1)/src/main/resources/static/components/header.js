class Header extends HTMLElement {
  constructor() {
    super();
  }

  connectedCallback() {
    this.innerHTML = `

      <header>
        <div class="navbar">
			<nav>
				<div class="left_menu">
					<a href="#home"><img src="Rythm_logo.png" width="100px"
						height="80px" id=logo alt="Logo image" style="margin-left: 10px;" /></a>
					<button>HOME</button> <a href="#news">PODCASTS</a> 
					<!-- <a href="#contact">LIBRARY</a> -->
					<div class="dropdown">
						<button class="dropbtn">
							LIBRARY <i class="fa fa-caret-down"></i>
						</button>
						<div class="dropdown-content">
							<button id="my-music-btn">Music</button>
							
							<a th:href="@{/users/myPodcast}">Podcasts</a>
						</div>
					</div>
				</div>
				<div class="right_menu">
					<div class="dropdown">
						<button class="dropbtn">
							ACCOUNT <i class="fa fa-caret-down"></i>
						</button>
						<div class="dropdown-content">
							<!-- <a href="#">LOGOUT</a> -->
							<form action="#" th:action="@{/logout}" method="POST">
								<a href="#"><input type="submit" value="LOGOUT" /></a>
							</form>
							
							<a href="#">Link 2</a> 
						</div>
					</div>
				</div>
			</nav>

		</div>
      </header>
    `;
  }
}

customElements.define('header-component', Header);
