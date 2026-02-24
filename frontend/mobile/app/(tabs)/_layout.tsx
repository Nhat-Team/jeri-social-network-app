import {Tabs} from "expo-router";
import {Text, View} from "react-native";
import HeaderComponent from "@/components/header";

export default function TabLayout() {
    return (
        <Tabs screenOptions={{
            tabBarActiveTintColor: "red",
            header: () => <HeaderComponent/>
        }}>
            <Tabs.Screen name={"index"} />
            <Tabs.Screen name={"contact"} />
            <Tabs.Screen name={"feed"} />
            <Tabs.Screen name={"profile"} />
        </Tabs>
    )
}