const assert = require('assert');
const PhotoComponent = require('../../js/application/photos/components/Photo');

describe('#Photo', () => {
    console.log(new PhotoComponent());

    it('represent a single photo', () => {
        assert.equal(1, 1);
    });
});
