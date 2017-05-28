const URL = '/api/v1/feed';

export function getPhotos() {
    return window.fetch(URL)
        .then(res => res.json());
}