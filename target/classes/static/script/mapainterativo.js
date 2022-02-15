mapboxgl.accessToken =
    'pk.eyJ1IjoicGVkcm9yb2NzIiwiYSI6ImNrd3J1MWJ6YjEwMTIybmp2N3lxMjIwMnMifQ.K77G5ulG3iUpSZo1vz7iYw';
const map = new mapboxgl.Map({
    container: 'map',
    style: 'mapbox://styles/pedrorocs/ckwzpgwvq024914muemz0g5x4',
    center: [-46.6642375407539, -23.515192189914238],
    zoom: 8
});

const marker1 = new mapboxgl.Marker()
    .setLngLat([-46.65737680,-23.74045100])
    .addTo(map);

    const marker2 = new mapboxgl.Marker()
    .setLngLat([ -46.695889524227496,-23.74228853957957,])
    .addTo(map);

    const marker3 = new mapboxgl.Marker()
    .setLngLat([  -46.45986648359847,-23.521956511238397,])
    .addTo(map);

