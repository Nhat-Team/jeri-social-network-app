import dataFriend from "@/data/contact/list_friend.json";
import Feather from "@expo/vector-icons/Feather";
import Ionicons from "@expo/vector-icons/Ionicons";
import { useEffect, useState } from "react";
import { Pressable, ScrollView, View } from "react-native";
import CustomAvatar from "../styles/CustomAvatar";
import CustomIcon from "../styles/CustomIcon";
import CustomSafeAreaView from "../styles/CustomSafeAreaView";
import CustomText from "../styles/CustomText";
import CustomTouchableOpacity from "../styles/CustomTouchableOpacity";

export default function ListFriendComponent({
  subTabMenuSelected,
}: {
  subTabMenuSelected: number;
}) {
  const [listFriends, setListFriends] = useState<object[]>([]);

  useEffect(() => {
    const getData = async () => {
      return dataFriend;
    };
    getData().then((data) => {
      setListFriends(data);
    });
  });

  return subTabMenuSelected === 0 ? (
    <CustomSafeAreaView
      backgroundPriority="secondary"
      styles={{
        padding: 0,
      }}
    >
      <ScrollView>
        {listFriends
          .sort((a: any, b: any) => a.firstName.localeCompare(b.firstName))
          .map((friend: any, index: number) => {
            return (
              <CustomTouchableOpacity
                backgroundPriority="secondary"
                key={index}
                styles={{
                  display: "flex",
                  flexDirection: "row",
                  justifyContent: "space-between",
                  alignItems: "center",
                  borderRadius: 0,
                  borderWidth: 1,
                  marginTop: 10,
                }}
              >
                <View
                  style={{
                    display: "flex",
                    flexDirection: "row",
                    alignItems: "center",
                  }}
                >
                  <CustomAvatar
                    uri={friend.avatar}
                    styles={{ width: 60, height: 60 }}
                  />

                  <CustomText
                    content={friend.firstName + " " + friend.lastName}
                    styles={{
                      marginLeft: 10,
                    }}
                  />
                </View>

                <View
                  style={{
                    display: "flex",
                    flexDirection: "row",
                    alignItems: "center",
                  }}
                >
                  <Pressable>
                    <CustomIcon
                      icon={<Ionicons name="call-outline" size={30} />}
                    />
                  </Pressable>

                  <Pressable
                    style={{
                      marginLeft: 20,
                      marginRight: 10,
                    }}
                  >
                    <CustomIcon
                      icon={<Feather name="video" size={30} color="black" />}
                    />
                  </Pressable>
                </View>
              </CustomTouchableOpacity>
            );
          })}
      </ScrollView>
    </CustomSafeAreaView>
  ) : (
    <CustomSafeAreaView>
      <CustomText content="Đang cập nhật..." />
    </CustomSafeAreaView>
  );
}
