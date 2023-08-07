import * as React from 'react';
import { useState } from 'react';
import SvgIcon from '@mui/material/SvgIcon';
import ThumbUpIcon from '@mui/icons-material/ThumbUp';
import FavoriteIcon from '@mui/icons-material/Favorite';
import RecommendOutlinedIcon from '@mui/icons-material/RecommendOutlined';
import ToggleButton from '@mui/material/ToggleButton';
// import IconButton from '@mui/material/IconButton';

export default function LikeButton() {
    const [selected, setSelected] = React.useState(false);
    const [likes, setLikes] = useState(100);
    const [isClicked, setIsClicked] = useState(false);
    const [nameLike,setNameLike] = useState("Like");
    const [buttonColor, setButtonColor] = useState('#d3d3d3');
    

    const handleClick = () => {
        if (isClicked) {
            setLikes(likes - 1);
            setButtonColor('#d3d3d3')
            setNameLike("Like");

        } else {
            setLikes(likes + 1);
            setButtonColor('#003566')
            setNameLike("UnLike");
        }
        setIsClicked(!isClicked);
    };
    

    return (

        // <ToggleButton
        //   value="check"
        //   selected={selected}
        //   onChange={() => {
        //     setSelected(!selected);
        //   }}
        // >
        //   <RecommendOutlinedIcon  />
        // </ToggleButton>
        <div>
            <button className={`like-button ${isClicked && 'liked'}`} onClick={handleClick}>
                <span className="likes-counter" style={{ border: 'none', color: buttonColor , padding: "15px", fontSize: "22px"}}><SvgIcon component={ThumbUpIcon} inheritViewBox  />{`  ${likes}`}</span>  
            </button>
        </div>

        // <span >{`${nameLike}`}</span>


    );
}