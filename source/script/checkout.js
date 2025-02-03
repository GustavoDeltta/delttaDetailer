document.addEventListener("DOMContentLoaded", function () {

    const urlParams = new URLSearchParams(window.location.search);
    const serviceId = urlParams.get("serviceId");

    document.getElementById("back").addEventListener("click", function() {
        window.location.href = "/index.html"; 
    });

    if (serviceId) {
        
        fetch(`http://localhost:8080/services/${serviceId}`)
            .then(response => response.json())
            .then(service => {

                document.getElementById("service").textContent = service.name;
                document.getElementById("price").textContent = `R$${service.price.toFixed(2)}`;

                document.getElementById("confirm").addEventListener("click", function () {
                    const appointmentData = {
                        clientName: document.getElementById("name").value,
                        clientContact: document.getElementById("contact").value,
                        date: document.getElementById("date").value,
                        time: document.getElementById("time").value,
                        serviceId: service.id
                    };

                    fetch("http://localhost:8080/appointments", {
                        method: "POST",
                        headers: {
                            "Content-Type": "application/json"
                        },
                        body: JSON.stringify(appointmentData)
                    })
                    .then(response => response.json())
                    .then(data => {
                        alert("Agendamento confirmado com sucesso!");
                    })
                    .catch(error => console.error("Erro ao confirmar agendamento:", error));
                });
            })
            .catch(error => console.error("Erro ao carregar o serviço:", error));
    } else {
        console.error("Nenhum serviço encontrado na URL.");
    }
});
