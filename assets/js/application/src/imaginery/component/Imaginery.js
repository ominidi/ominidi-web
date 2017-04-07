import React, {PropTypes} from "react";
import Triangles from '../animation/Triangles';

export default class Imaginery extends  React.Component {
    constructor(props) {
        super(props);
    }

    componentDidMount() {
        const scene = Triangles.getScene();
        const camera = Triangles.getCamera();
        const renderer = Triangles.getRenderer(this.props.width, this.props.height);
        const shapes = [
            Triangles.getTetra(this.props.width / 1.7, 2, '#B4FF00'),
            Triangles.getTetra(this.props.width / 1.6, 1, '#EEFF00'),
            Triangles.getTetra(this.props.width / 1.5, 2, '#FF0077'),
            Triangles.getTetra(this.props.width / 1.4, 2, '#0019FF'),
            Triangles.getTetra(this.props.width / 1.2, 2, '#FFFFFF')
        ];

        shapes.forEach(shape => {
            scene.add(shape);
        });

        document.querySelector('.masthead__picture').appendChild(renderer.domElement);
        Triangles.start(renderer, scene, camera, shapes)();
    }

    render() {
        return (
            <figure className="masthead__picture  imaginery" style={{ width: this.props.width, height: this.props.height }}/>
        );
    }
}

Imaginery.propTypes = {
    width: PropTypes.number,
    height: PropTypes.number
};