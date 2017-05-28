import assert from 'assert';
import sinon from 'sinon';
import { getPhotos } from '../../../src/photos/services/feed-service';

describe('#feedService', () => {
    let window = { fetch() {} },
        fetchFn;

    beforeEach(() => {
        fetchFn = sinon.stub(window, 'fetch').callsFake(() => new Promise());
    });

    afterEach(() => {
        fetchFn.reset();
    });

    it('should return a promise wrapping the photos of the feed', (done) => {
        getPhotos()
            .then((data) => {
                assert.notNull(data);
                done();
            }).catch(e => console.log(e));
    });
});
