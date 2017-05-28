const URL = '/api/v1/feed';

export function getPhotos() {
    return window.fetch();


    // window.fetch('/api/v1/feed')
    //     .then(res => res.json())
    //     .then(data => this.setState(Object.assign(data, {loading: false})))
    //     .catch(e => console.log(e));
}