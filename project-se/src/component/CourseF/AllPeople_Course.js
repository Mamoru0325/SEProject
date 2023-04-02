import CourseMenu from "./CourseMenu"
import './AllPeople_Course.css'
import AcceptPeople_Course from "./AcceptPeople_Course"
import ListPeople_Course from "./ListPeople_Course"
import MyCourse_All from "./MyCourse_All";
import Button from '@material-ui/core/Button';
import { IoIosArrowBack } from "react-icons/io";
import { NavLink } from 'react-router-dom';


function AllPeople_Course() {
    return (
        <dev >
            <CourseMenu />
            <dev>
                <h1 className="textnameCourse"
            >
                <NavLink className={"buttonbackC"} to="/MyCourse_All" ><IoIosArrowBack/>Back</NavLink>
                Name Course
            </h1>
            </dev>
            <dev className="boxPeople">
                <dev><ListPeople_Course /></dev>
                <dev><AcceptPeople_Course /></dev>
            </dev>
        </dev>

    )

}

export default AllPeople_Course