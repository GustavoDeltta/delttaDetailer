document.addEventListener("DOMContentLoaded", function () {
    fetch("http://localhost:8080/services")
        .then(response => response.json())
        .then(data => {
            const servicesContainer = document.getElementById("catalog");

            data.forEach(service => {
                const serviceDiv = document.createElement("div");
                serviceDiv.classList.add("service");
                serviceDiv.innerHTML = `
                    <div class="title">
                        <h2>${service.name}</h2>
                    </div>
                    <div class="service-details">
                        <div class="serviceimg">
                            <img src="${service.imglink}" alt="${service.name}">
                        </div>   
                        <div class="description">
                            <p>${service.description}</p>
                        </div>
                    </div>               
                    <div class="service-buttons">
                        <div class="price">
                            <p>R$${service.price.toFixed(2)}</p>
                        </div>
                        <div class="more">
                            <img id="moreicon" src="source/assets/mais-zoom.png">
                        </div>
                        <div class="schedule">
                            <button class="schedule-btn" data-id="${service.id}">Agendar!</button>
                        </div>
                    </div> 
                `;
                servicesContainer.appendChild(serviceDiv);
            });
            document.querySelectorAll(".schedule-btn").forEach(button => {
                button.addEventListener("click", function () {
                    const serviceId = this.getAttribute("data-id");
                    window.location.href = `/source/html/checkout.html?serviceId=${serviceId}`;
                });
            });
        })
        .catch(error => console.error("Erro ao carregar serviços:", error));
});
