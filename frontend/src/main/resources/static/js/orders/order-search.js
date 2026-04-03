function handleOrderIdKeyPress(event) {
    if (event.key === 'Enter') {
        navigateToOrder();
    }
}

function navigateToOrder() {
    const orderIdInput = document.getElementById('orderIdInput');
    const orderId = orderIdInput.value.trim();

    if (orderId && orderId > 0) {
        // Navigate to the order details page with the entered ID
        window.location.href = '/orders/detail/' + orderId;
    } else {
        // Show error feedback
        orderIdInput.style.borderColor = 'hsl(0, 70%, 50%)';
        orderIdInput.focus();

        // Reset border color after 2 seconds
        setTimeout(() => {
            orderIdInput.style.borderColor = '';
        }, 2000);
    }
}

// Focus on input field when page loads
document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('orderIdInput').focus();
});
