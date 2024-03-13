const form = document.getElementById("qr-code-form");
const qrCodeId = document.getElementById("qr-code-id");
const qrCode = document.getElementById("qr-code");

form.addEventListener("submit", async (event) => {
    event.preventDefault();

    const courseId = document.getElementById("course-id").value;
    const lecturerName = document.getElementById("lecturer-name").value;
    const studentsTaken = document.getElementById("students-taken").value;
    const time = document.getElementById("time").value;

    const qrCodeData = {
        qrCodeId: generateUniqueQRCodeId(),
        courseId,
        lecturerName,
        studentsTaken,
        time
    };

    try {
        const response = await fetch("http://localhost:8080/generate-qr-code", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(qrCodeData)
        });

        if (!response.ok) {
            throw new Error("Failed to generate QR code");
        }

        const qrCodeUrl = await response.text();
        qrCode.innerHTML = `<img src="${qrCodeUrl}" alt="QR Code">`;
    } catch (error) {
        alert("Failed to generate QR code. Please try again.");
        console.error(error);
    }
});

function generateUniqueQRCodeId() {
    let qrCodeIdValue = "";
    do {
        qrCodeIdValue = generateRandomString(10);
    } while (document.getElementById("qr-code-id") && document.getElementById("qr-code-id").value === qrCodeIdValue);
    document.getElementById("qr-code-id").value = qrCodeIdValue;
    return qrCodeIdValue;
}

function generateRandomString(length) {
    let text = "";
    const possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    for (let i = 0; i < length; i++) {
        text += possible.charAt(Math.floor(Math.random() * possible.length));
    }

    return text;
}