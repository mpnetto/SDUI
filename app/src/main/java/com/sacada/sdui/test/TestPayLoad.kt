package com.sacada.sdui.test

val samplePayload = """
{
    "topBar": {
        "id": "topBar1",
        "type": "center",
        "attributes": {
            "title": "Now in Android",
            "scrollBehavior": "pinned"
        },
        "children": [
            {
                "id": "navigationIcon1",
                "type": "navigationIcon",
                "attributes": {
                    "iconName": "search",
                    "contentDescription": "Menu"
                },
                "action": {
                    "type": "event",
                    "destination": "goBack"
                }
            },
            {
                "id": "action1",
                "type": "Action",
                "attributes": {
                    "iconName": "person",
                    "contentDescription": "Menu"
                },
                "action": {
                    "type": "event",
                    "destination": "goBack"
                }
            }
        ]
    },
    "bottomBar": {
        "id": "bottomBar1",
        "type": "BottomBar",
        "children": [
            {
                "id": "actionHome",
                "type": "Action",
                "attributes": {
                    "iconName": "home",
                    "contentDescription": "Home"
                },
                "action": {
                    "type": "navigate",
                    "destination": "homeScreen"
                }
            },
            {
                "id": "actionSearch",
                "type": "Action",
                "attributes": {
                    "iconName": "search",
                    "contentDescription": "Search"
                },
                "action": {
                    "type": "navigate",
                    "destination": "searchScreen"
                }
            },
            {
                "id": "fab1",
                "type": "FloatingActionButton",
                "attributes": {
                    "iconName": "arrow_forward",
                    "contentDescription": "Add"
                },
                "action": {
                    "type": "event",
                    "destination": "addItem"
                }
            }
        ]
    },
    "layout": {
        "id": "layout1",
        "type": "Column",
        "attributes": {
            "verticalArrangement": "SpaceBetween",
            "fillMaxSize": "true"
        },
        "children": [
            {
                "id": "column1",
                "type": "Column",
                "attributes": {
                    "horizontalAlignment": "Start",
                    "padding": "24"
                },
                "children": [
                    {
                        "id": "text1",
                        "type": "Text",
                        "attributes": {
                            "content": "What are you interested in?",
                            "style": "titleLarge"
                        }
                    },
                    {
                        "id": "text2",
                        "type": "Text",
                        "attributes": {
                            "content": "Updates from interests you follow will appear here. Follow some things to get started.",
                            "style": "bodyMedium",
                            "padding": "12"
                        }
                    }
                ]
            },
            {
                "id": "row1",
                "type": "Row",
                "attributes": {
                    "horizontalArrangement": "SpaceBetween",
                    "padding": "16"
                },
                "children": [
                    {
                        "id": "buttonConfirm",
                        "type": "Button",
                        "attributes": {
                            "text": "Confirmar"
                        },
                        "action": {
                            "type": "event",
                            "destination": "confirmAction"
                        }
                    },
                    {
                        "id": "buttonCancel",
                        "type": "Button",
                        "attributes": {
                            "text": "Cancelar"
                        },
                        "action": {
                            "type": "event",
                            "destination": "cancelAction"
                        }
                    }
                ]
            }
        ]
    }
}
"""
