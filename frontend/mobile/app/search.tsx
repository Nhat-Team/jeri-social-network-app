import CustomSafeAreaView from "@/components/styles/CustomSafeAreaView";
import { Text } from "react-native";

export default function Search() {
    return (
        <CustomSafeAreaView styles={{
            backgroundColor: "white"
        }}>
            <Text>Search Screen</Text>
        </CustomSafeAreaView>
    )
}