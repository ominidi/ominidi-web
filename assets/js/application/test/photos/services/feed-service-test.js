import assert from 'assert';
import sinon from 'sinon';
import { getPhotos } from '../../../src/photos/services/feed-service';

describe('#feedService', () => {
    global.window = {fetch() {}};
    global.Response = { json(){}};

    let fetchFn,
        jsonFn,
        data = {
            "posts": [{
                "id": "221685698257476_292922074467171",
                "objectId": "292922074467171",
                "createdTime": "2017-05-26T07:38:36+0000",
                "type": "photo",
                "link": "https://www.facebook.com/ominidi.org/photos/a.221947308231315.1073741828.221685698257476/292922074467171/?type=3",
                "permalinkUrl": "https://www.facebook.com/ominidi.org/posts/292922074467171:0",
                "picture": "https://scontent.xx.fbcdn.net/v/t1.0-0/p130x130/18671171_292922074467171_2281494834640916147_n.jpg?oh=2fea20af8a4b16474038eed0a1afa9ba&oe=59AE6949",
                "fullPicture": "https://scontent.xx.fbcdn.net/v/t1.0-9/p720x720/18671171_292922074467171_2281494834640916147_n.jpg?oh=c3b542784082cebc9125f302d7c8cd66&oe=59A052B6",
                "message": "Il #manifesto di Ominidi.org:\nhttps://www.ominidi.org/manifesto\n\n#anarchy #ia #primitivismourbano"
            }],
            "nextUrl": "https://graph.facebook.com/v2.8/221685698257476/feed?fields=id,object_id,created_time,type,link,permalink_url,picture,full_picture,message&format=json&access_token=253231091758727|I3y2JqlMVz1eTEneDhFZ8FS6VcE&limit=25&until=1492670335&__paging_token=enc_AdBtQtIu0VGY1o5oDhNeMdIZCPMKNeiLOPjlXC3nZBP3p5MkqZAp2cBNwqMG067HtK1utrVZARYFEwlErzipWmKkQk1A0ZC6BQu7WnvBc74U87B0b7wZDZD",
            "prevUrl": "https://graph.facebook.com/v2.8/221685698257476/feed?fields=id,object_id,created_time,type,link,permalink_url,picture,full_picture,message&format=json&since=1495784316&access_token=253231091758727|I3y2JqlMVz1eTEneDhFZ8FS6VcE&limit=25&__paging_token=enc_AdCDNdIFfpq1PeVPJijHMTzDd3WWbXeqivOSXbmzHXZCfs4ucvCuuafgpc4zct4wYLeHaOBhQ0GZBE3ZCH5Y7NpadjFcWQDGqaHPuau6CD08YhclQZDZD&__previous=1",
            "size": 25
        };

    beforeEach(() => {
        fetchFn = sinon.stub(window, 'fetch');
        jsonFn = sinon.stub(Response, 'json');
    });

    afterEach(() => {
        fetchFn.reset();
    });

    it('should return a promise wrapping the photos of the feed', done => {
        jsonFn.callsFake(() => data);
        fetchFn.callsFake(() => new Promise((resolve, reject) => resolve(Response)));

        getPhotos()
            .then(posts => {
                assert.deepEqual(data, posts);
                done();
            }).catch(e => console.log(e));
    });
});
