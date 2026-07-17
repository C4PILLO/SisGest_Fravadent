// scripts.js — Fravadent
// Lógica JS común de la aplicación. Cada módulo (venta, compra, etc.)
// puede tener su propio <script> adicional dentro de su vista.

document.addEventListener('DOMContentLoaded', () => {
    // Activa los tooltips de Bootstrap si se usan en algún botón
    const tooltipTriggerList = document.querySelectorAll('[data-bs-toggle="tooltip"]');
    tooltipTriggerList.forEach(el => new bootstrap.Tooltip(el));
});
