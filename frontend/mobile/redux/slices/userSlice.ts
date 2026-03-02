import {createSlice} from "@reduxjs/toolkit";

export const userSlice = createSlice({
    name: "userSlice",
    initialState: {
        avatar: "",
        firstName: "",
        lastName: ""
    },
    reducers: {
        setUserSlice: (user: object, _action): object => {
            return user;
        }
    }
});

export const { setUserSlice } = userSlice.actions;
export default userSlice.reducer;