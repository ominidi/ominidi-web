import assert from 'assert';
import React from 'react';
import {shallow} from 'enzyme';
import Feed from '../../../src/photos/components/Feed';
import Photo from '../../../src/photos/components/Photo';
import LoadingSpinner from '../../../src/photos/components/LoadingSpinner';

const data = {
    posts: [
        {
            type: 'photo',
            message: 'Lorem Ipsum',
            objectId: '221946658231380',
            link: 'https://www.facebook.com/ominidi.org/photos/a.221947308231315.1073741828.221685698257476/221946658231380/?type=3',
            permalinkUrl: 'https://www.facebook.com/ominidi.org/posts/221946658231380:0',
            fullPicture: 'https://scontent.xx.fbcdn.net/v/t1.0-9/p720x720/15350731_221946658231380_7655843372792046975_n.jpg?oh=fff641748cce57b36d1db68ce74ced02&oe=58BDC3C6',
            id: '221685698257476_221946658231380'
        },
        {
            type: 'photo',
            message: 'Lorem Ipsum',
            objectId: '221946658231380',
            link: 'https://www.facebook.com/ominidi.org/photos/a.221947308231315.1073741828.221685698257476/221946658231380/?type=3',
            permalinkUrl: 'https://www.facebook.com/ominidi.org/posts/221946658231380:0',
            fullPicture: 'https://scontent.xx.fbcdn.net/v/t1.0-9/p720x720/15350731_221946658231380_7655843372792046975_n.jpg?oh=fff641748cce57b36d1db68ce74ced02&oe=58BDC3C6',
            id: '221685698257476_221946658231380'
        }
    ]
};

describe('#Feed', () => {
    it('should render various items of the feed', () => {
        const wrapper = shallow(<Feed />);
        wrapper.setState(data);

        assert.equal(wrapper.hasClass('feed'), true);
        assert.equal(wrapper.find(Photo).length, data.posts.length);
    });

    it('should render only feed item of type "photo"', () => {
        data.posts.push({
            type: 'link',
            id: '221685698257476_263132530779459',
            objectId: null,
            link: 'https://github.com/ominidi/design-guidelines',
            permalinkUrl: 'https://www.facebook.com/ominidi.org/posts/263132530779459',
            picture: 'https://external.xx.fbcdn.net/safe_image.php?d=AQB6Q3NBu3mrm63X&w=130&h=130&url=https%3A%2F%2Favatars1.githubusercontent.com%2Fu%2F24454484%3Fv%3D3%26s%3D400&cfs=1&sx=0&sy=0&sw=356&sh=356&_nc_hash=AQAAn3Nco2uCm96e',
            fullPicture: 'https://external.xx.fbcdn.net/safe_image.php?d=AQBO7kq35N_ydScG&url=https%3A%2F%2Favatars1.githubusercontent.com%2Fu%2F24454484%3Fv%3D3%26s%3D400&_nc_hash=AQDZXZgA6ExQ3dul',
            message: 'Lorem Ipsum'
        });

        const wrapper = shallow(<Feed />);
        wrapper.setState(data);

        assert.equal(wrapper.find(Photo).length, data.posts.length -1);
    });

    it('should render a loading spinner', () => {
        const wrapper = shallow(<Feed />);
        wrapper.setState(data);

        assert.equal(wrapper.find(LoadingSpinner).length, 1);
    });
});
