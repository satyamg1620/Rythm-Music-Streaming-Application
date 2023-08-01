class MusicTable extends HTMLElement {
	constructor() {
		super();
	}

	connectedCallback() {
		this.innerHTML = `

      <div align="center" id="songs-list">
			<!-- Display Username and Role -->
			<table class="table table-striped">
				<tr class="bg-info">
					<th class="highlight"><div></div></th>
					<th>Track</th>
					<!--<th>Path</th>-->
				</tr>
				<tbody id="myTable">
				</tbody>
			</table>
		</div>
    `;
	}
}

customElements.define('music-table-component', MusicTable);
